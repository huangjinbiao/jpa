package com.sgmw;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author
 * @date 2019/9/2
 */
@Entity
@Table(name = "VIEWS", schema = "information_schema", catalog = "")
public class ViewsEntity {
    private String characterSetClient;
    private String checkOption;
    private String collationConnection;
    private String definer;
    private String isUpdatable;
    private String securityType;
    private String tableCatalog;
    private String tableName;
    private String tableSchema;
    private String viewDefinition;

    @Basic
    @Column(name = "CHARACTER_SET_CLIENT")
    public String getCharacterSetClient() {
        return characterSetClient;
    }

    public void setCharacterSetClient(String characterSetClient) {
        this.characterSetClient = characterSetClient;
    }

    @Basic
    @Column(name = "CHECK_OPTION")
    public String getCheckOption() {
        return checkOption;
    }

    public void setCheckOption(String checkOption) {
        this.checkOption = checkOption;
    }

    @Basic
    @Column(name = "COLLATION_CONNECTION")
    public String getCollationConnection() {
        return collationConnection;
    }

    public void setCollationConnection(String collationConnection) {
        this.collationConnection = collationConnection;
    }

    @Basic
    @Column(name = "DEFINER")
    public String getDefiner() {
        return definer;
    }

    public void setDefiner(String definer) {
        this.definer = definer;
    }

    @Basic
    @Column(name = "IS_UPDATABLE")
    public String getIsUpdatable() {
        return isUpdatable;
    }

    public void setIsUpdatable(String isUpdatable) {
        this.isUpdatable = isUpdatable;
    }

    @Basic
    @Column(name = "SECURITY_TYPE")
    public String getSecurityType() {
        return securityType;
    }

    public void setSecurityType(String securityType) {
        this.securityType = securityType;
    }

    @Basic
    @Column(name = "TABLE_CATALOG")
    public String getTableCatalog() {
        return tableCatalog;
    }

    public void setTableCatalog(String tableCatalog) {
        this.tableCatalog = tableCatalog;
    }

    @Basic
    @Column(name = "TABLE_NAME")
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Basic
    @Column(name = "TABLE_SCHEMA")
    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    @Basic
    @Column(name = "VIEW_DEFINITION")
    public String getViewDefinition() {
        return viewDefinition;
    }

    public void setViewDefinition(String viewDefinition) {
        this.viewDefinition = viewDefinition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewsEntity that = (ViewsEntity) o;
        return Objects.equals(characterSetClient, that.characterSetClient) &&
                Objects.equals(checkOption, that.checkOption) &&
                Objects.equals(collationConnection, that.collationConnection) &&
                Objects.equals(definer, that.definer) &&
                Objects.equals(isUpdatable, that.isUpdatable) &&
                Objects.equals(securityType, that.securityType) &&
                Objects.equals(tableCatalog, that.tableCatalog) &&
                Objects.equals(tableName, that.tableName) &&
                Objects.equals(tableSchema, that.tableSchema) &&
                Objects.equals(viewDefinition, that.viewDefinition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characterSetClient, checkOption, collationConnection, definer, isUpdatable, securityType, tableCatalog, tableName, tableSchema, viewDefinition);
    }
}
