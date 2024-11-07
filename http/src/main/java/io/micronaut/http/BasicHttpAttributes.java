package io.micronaut.http;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.uri.UriMatchInfo;

import java.util.Optional;

/**
 * Accessors for basic attributes outside micronaut-http-router.
 *
 * @author Jonas Konrad
 * @since 4.8.0
 */
@SuppressWarnings("removal")
public final class BasicHttpAttributes {
    private BasicHttpAttributes() {
    }

    /**
     * Get the route match as a {@link UriMatchInfo}.
     *
     * @param request The request
     * @return The route match, if present
     */
    public static Optional<UriMatchInfo> getRouteMatchInfo(HttpRequest<?> request) {
        return request.getAttribute(HttpAttributes.ROUTE_MATCH, UriMatchInfo.class);
    }

    /**
     * Get the URI template as a String, for tracing.
     *
     * @param request The request
     * @return The template, if present
     */
    @NonNull
    public static Optional<String> getUriTemplate(HttpRequest<?> request) {
        return request.getAttribute(HttpAttributes.URI_TEMPLATE, String.class);
    }

    /**
     * Set the URI template as a String, for tracing.
     *
     * @param request     The request
     * @param uriTemplate The template, if present
     */
    public static void setUriTemplate(@NonNull HttpRequest<?> request, @NonNull String uriTemplate) {
        request.setAttribute(HttpAttributes.URI_TEMPLATE, uriTemplate);
    }

    /**
     * Get the client service ID.
     *
     * @param request The request
     * @return The client service ID
     */
    @NonNull
    public static Optional<String> getServiceId(@NonNull HttpRequest<?> request) {
        return request.getAttribute(HttpAttributes.SERVICE_ID, String.class);
    }
}
