package io.micronaut.http.client;

import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpAttributes;
import io.micronaut.http.HttpRequest;

import java.util.Optional;

/**
 * Client-related attribute accessors.
 *
 * @author Jonas Konrad
 * @since 4.8.0
 */
@SuppressWarnings("removal")
public final class ClientAttributes {
    private ClientAttributes() {
    }

    /**
     * Set the client service ID.
     *
     * @param request   The request
     * @param serviceId The client service ID
     * @see io.micronaut.http.BasicHttpAttributes#getServiceId(HttpRequest)
     */
    public static void setServiceId(@NonNull HttpRequest<?> request, @NonNull String serviceId) {
        request.setAttribute(HttpAttributes.SERVICE_ID, serviceId);
    }

    /**
     * Get the invocation context.
     *
     * @param request The request
     * @return The invocation context, if present
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @NonNull
    public static Optional<MethodInvocationContext<?, ?>> getInvocationContext(@NonNull HttpRequest<?> request) {
        return (Optional) request.getAttribute(HttpAttributes.INVOCATION_CONTEXT, MethodInvocationContext.class);
    }

    /**
     * Set the invocation context.
     *
     * @param request           The request
     * @param invocationContext The invocation context
     */
    public static void setInvocationContext(@NonNull HttpRequest<?> request, @NonNull MethodInvocationContext<?, ?> invocationContext) {
        request.setAttribute(HttpAttributes.INVOCATION_CONTEXT, invocationContext);
    }
}
