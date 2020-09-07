package com.kappakorp.hikaricp;

import org.springframework.util.Assert;

public class TenantContextHolder {

    private static final ThreadLocal<Object> contextHolder = new ThreadLocal<>();

    public static void setTenantType(Object tenantType) {
        Assert.notNull(tenantType, "tenantType cannot be null");
        contextHolder.set(tenantType);
    }

    public static Object getTenantType() {
        return (Object) contextHolder.get();
    }

    public static void clearTenantType() {
        contextHolder.remove();
    }
}
