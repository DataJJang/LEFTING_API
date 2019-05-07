package com.lefting.api.common.config;

import com.jcraft.jsch.ChannelSftp;
import java.io.File;
import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.outbound.SftpMessageHandler;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.handler.annotation.Header;


@Configuration
public class SftpConfig {

    @Value("${juvis.file.server}")
    private String sftpHost;

    @Value("${juvis.file.port:22}")
    private int sftpPort;

    @Value("${juvis.file.username}")
    private String sftpUser;

    @Value("${juvis.file.password:#{null}}")
    private String sftpPasword;

    @Value("${sftp.privateKey:#{null}}")
    private Resource sftpPrivateKey;

    @Value("${sftp.privateKeyPassphrase:}")
    private String sftpPrivateKeyPassphrase;

    @Value("${juvis.file.physical:/}")
    private String sftpRemoteDirectory;

    @Bean
    public SessionFactory<ChannelSftp.LsEntry> sftpSessionFactory() {
        DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
        factory.setHost(sftpHost);
        factory.setPort(sftpPort);
        factory.setUser(sftpUser);
        if (sftpPrivateKey != null) {
            factory.setPrivateKey(sftpPrivateKey);
            factory.setPrivateKeyPassphrase(sftpPrivateKeyPassphrase);
        } else {
            factory.setPassword(sftpPasword);
        }
        factory.setAllowUnknownKeys(true);
        return new CachingSessionFactory<ChannelSftp.LsEntry>(factory);
    }

    @Bean
    @ServiceActivator(inputChannel = "toSftpChannel")
    public MessageHandler handler() {
        SftpMessageHandler handler = new SftpMessageHandler(sftpSessionFactory());
        handler.setAutoCreateDirectory(true);
//        handler.setRemoteDirectoryExpression(new LiteralExpression(sftpRemoteDirectory));
//        handler.setRemoteFileSeparator("/");
//        handler.setRemoteDirectoryExpression(new LiteralExpression(sftpRemoteDirectory));
//        handler.setRemoteDirectoryExpression(new LiteralExpression(""));

        ExpressionParser EXPRESSION_PARSER = new SpelExpressionParser();
        handler.setRemoteDirectoryExpression(EXPRESSION_PARSER.parseExpression("headers['path']"));

        return handler;
    }

    @MessagingGateway
    public interface UploadGateway {
        @Gateway(requestChannel = "toSftpChannel")
        void upload(File file, @Header("filename") String filename, @Header("path") String path);
    }

    public static String getRandomInt(int length) {
        String str = "";
        int d = 0;
        for (int i=0; i<length; i++) {
            Random r = new Random();
            d = r.nextInt(9);
            str = str + Integer.toString(d);
        }
        return str;
    }
}
