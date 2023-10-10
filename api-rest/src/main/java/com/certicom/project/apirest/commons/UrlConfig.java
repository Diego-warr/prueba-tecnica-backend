package com.certicom.project.apirest.commons;

import java.util.Arrays;
import java.util.List;

public class UrlConfig {

    public static final String URL_ALL = "/**";
    public static final String URL_PREFIX = "/api";
    public static final String URL_PUBLIC_PREFIX = URL_PREFIX + "/public";
    public static final String URL_PUBLIC = URL_PUBLIC_PREFIX + "/**";
    public static final String  URL_AUTH_PREFIX = URL_PREFIX + "/auth";
    public static final String URL_AUTH = URL_AUTH_PREFIX + "/**";
    public static final String URL_TEST_PREFIX = URL_PREFIX + "/test";
    public static final String URL_TEST = URL_TEST_PREFIX + "/**";
    public static final List<String> URL_PREFIX_WITHOUT_SECURITY = Arrays.asList(URL_PUBLIC_PREFIX, URL_TEST_PREFIX);
    public static final List<String> URL_SWAGGER_WITHOUT_SECURITY= Arrays.asList(
            "/v3/api-docs",
            "/v3/api-docs/swagger-config",
            "/swagger-ui/.+\\.html",
            "/swagger-ui/.+\\.css",
            "/swagger-ui/.+\\.js",
            "/swagger-ui/.+\\.png"
    );
    public static final String[] SWAGGER_WHITELIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**.html",
            "/swagger-ui/**.css",
            "/swagger-ui/**.js",
            "/swagger-ui/**.png"
    };

    public static class ClienteUrl{
        public static final String TAG ="Cliente";

        public static class Query{
            public static final String PREFIX = URL_AUTH_PREFIX+"/cliente-query";
            public static final String FIND_ALL="/all-clientes";

        }

        public static class Command{
            public static final String PREFIX = URL_AUTH_PREFIX+"/cliente-command";
            public static final String REGISTRAR="/regitrar";
        }
    }

    public static class ProductoUrl{
        public static final String TAG = "Producto";

        public static class Query{
            public static final String PREFIX = URL_AUTH_PREFIX+"/producto-query";
            public static final String LISTA_PAGINADA="/productos-page";

        }

        public static class Command{
            public static final String PREFIX = URL_AUTH_PREFIX+"/producto-command";
            public static final String REGISTRO="/registro";
            public static final String ACTUALIZAR="/actualizar";
            public static final String ELIMINAR="/eliminar";
        }
    }

    public static class VentaUrl{
        public static final String TAG = "Venta";

        public static class Query{
            public static final String PREFIX = URL_AUTH_PREFIX+"/venta-query";
            public static final String CONSULTA_POR_FECHA="/fecha";
            public static final String CONSULTA_POR_ID="/id";
        }

        public static class Command{
            public static final String PREFIX = URL_AUTH_PREFIX+"/venta-command";
            public static final String REGISTRO="/registro";
        }

    }
}
