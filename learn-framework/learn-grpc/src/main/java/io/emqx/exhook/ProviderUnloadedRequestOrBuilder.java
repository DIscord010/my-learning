// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: exhook.proto

package io.emqx.exhook;

public interface ProviderUnloadedRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:emqx.exhook.v2.ProviderUnloadedRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 1;</code>
   * @return Whether the meta field is set.
   */
  boolean hasMeta();
  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 1;</code>
   * @return The meta.
   */
  io.emqx.exhook.RequestMeta getMeta();
  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 1;</code>
   */
  io.emqx.exhook.RequestMetaOrBuilder getMetaOrBuilder();
}