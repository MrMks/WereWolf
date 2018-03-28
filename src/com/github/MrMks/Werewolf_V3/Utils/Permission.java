package com.github.MrMks.Werewolf_V3.Utils;

public interface Permission extends PermissionReader,PermissionWriter{
    @Override
    void addPermission(String permissionCode);

    @Override
    void addPermission(String[] permissionCodes);

    @Override
    void removePermission(String permissionCode);

    @Override
    void removePermission(String[] permissionCodes);

    @Override
    boolean hasPermission(String permissionCode);

    @Override
    boolean hasPermission(String[] permissionCodes);
}
