package com.coremedia.blueprint.connectors.sfmc;


import com.coremedia.blueprint.connectors.api.ConnectorCategory;
import com.coremedia.blueprint.connectors.api.ConnectorContext;
import com.coremedia.blueprint.connectors.api.ConnectorEntity;
import com.coremedia.blueprint.connectors.api.ConnectorId;
import com.coremedia.blueprint.connectors.sfmc.rest.documents.SFMCEntity;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;

import java.util.Date;

public class SFMCConnectorEntity implements ConnectorEntity {

  private ConnectorId connectorId;
  private String name;
  private ConnectorContext context;
  private ConnectorCategory parent;
  private SFMCEntity entity;

  SFMCConnectorServiceImpl service;

  SFMCConnectorEntity(SFMCConnectorServiceImpl service, ConnectorCategory parent, SFMCEntity entity, ConnectorContext context, ConnectorId connectorId) {
    this.service = service;
    this.context = context;
    this.connectorId = connectorId;
    this.parent = parent;

    if(entity != null) {
      this.name = entity.getName();
    }
  }

  @Override
  public boolean isDeleteable() {
    return false;
  }

  @Override
  public boolean delete() {
    return false;
  }

  public Date getLastModified() {
    return null;
  }

  @NonNull
  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @NonNull
  @Override
  public ConnectorContext getContext() {
    return context;
  }

  @Override
  public ConnectorCategory getParent() {
    return parent;
  }

  public void setParent(ConnectorCategory parent) {
    this.parent = parent;
  }

  @NonNull
  @Override
  public String getDisplayName() {
    return getName();
  }

  @NonNull
  @Override
  public ConnectorId getConnectorId() {
    return connectorId;
  }

  @Nullable
  @Override
  public String getManagementUrl() {
    return null;
  }
}