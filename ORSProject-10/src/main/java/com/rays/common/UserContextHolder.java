package com.rays.common;

/**
 * UserContextHolder provides a thread-safe mechanism to store and access
 * the current user's UserContext using {@link ThreadLocal}.
 * <p>
 * This is useful in multi-threaded applications to maintain user-specific
 * data (like authentication and role information) per thread/request.
 */
public class UserContextHolder {

    /** ThreadLocal to hold UserContext for the current thread */
    private static final ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    /**
     * Sets the UserContext for the current thread.
     *
     * @param context the UserContext to associate with the current thread
     */
    public static void setContext(UserContext context) {
        threadLocal.set(context);
    }

    /**
     * Returns the UserContext associated with the current thread.
     *
     * @return the current thread's UserContext, or null if none is set
     */
    public static UserContext getContext() {
        return threadLocal.get();
    }

    /**
     * Clears the UserContext for the current thread.
     * This should be called after the request processing is complete
     * to prevent memory leaks in a thread pool environment.
     */
    public static void clear() {
        threadLocal.remove();
    }
}