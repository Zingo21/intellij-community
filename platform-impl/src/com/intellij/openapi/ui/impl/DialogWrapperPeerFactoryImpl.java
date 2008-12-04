package com.intellij.openapi.ui.impl;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.DialogWrapperPeer;
import com.intellij.openapi.ui.DialogWrapperPeerFactory;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class DialogWrapperPeerFactoryImpl extends DialogWrapperPeerFactory {
  public DialogWrapperPeer createPeer(DialogWrapper wrapper, Project project, boolean canBeParent) {
    return new DialogWrapperPeerImpl(wrapper, project, canBeParent);
  }

  public DialogWrapperPeer createPeer(DialogWrapper wrapper, boolean canBeParent) {
    return new DialogWrapperPeerImpl(wrapper, canBeParent);
  }

  public DialogWrapperPeer createPeer(final DialogWrapper wrapper, final boolean canBeParent, final boolean tryToolkitModal) {
    return new DialogWrapperPeerImpl(wrapper, canBeParent, tryToolkitModal);
  }

  public DialogWrapperPeer createPeer(DialogWrapper wrapper, @NotNull Component parent, boolean canBeParent) {
    return new DialogWrapperPeerImpl(wrapper, parent, canBeParent);
  }
}