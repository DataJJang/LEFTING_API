package com.lefting.hybrid.common.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshFilter extends ConfigurableSiteMeshFilter {

    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/hybrid/*", "/WEB-INF/views/common/decorator/defaultDecorator.jsp")
                .addExcludedPath("/assets/*")
                .addExcludedPath("/api/*")
                .setMimeTypes("text/html");

        /*
        // Map default decorator. This shall be applied to all paths if no other paths match.
        builder.addDecoratorPath("/*", "/default-decorator.html")
            // Map decorators to path patterns.
            .addDecoratorPath("/admin/*", "/another-decorator.html")
            .addDecoratorPath("/*.special.jsp", "/special-decorator.html")
            // Map multiple decorators to the a single path.
            .addDecoratorPaths("/articles/*", "/decorators/article.html",
                    "/decoratos/two-page-layout.html",
                    "/decorators/common.html")
            // Exclude path from decoration.
            .addExcludedPath("/javadoc/*")
            .addExcludedPath("/brochures/*");
        */
    }
}
