package com.github.MrMks.Werewolf_V3.Utils;

public interface PermissionWriter {
    void addPermission(String permissionCode);
    void addPermission(String[] permissionCodes);

    void removePermission(String permissionCode);
    void removePermission(String[] permissionCodes);
}
