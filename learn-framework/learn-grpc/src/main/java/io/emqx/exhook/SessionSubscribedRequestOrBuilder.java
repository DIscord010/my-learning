// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: exhook.proto

package io.emqx.exhook;

public interface SessionSubscribedRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:emqx.exhook.v2.SessionSubscribedRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
   * @return Whether the clientinfo field is set.
   */
  boolean hasClientinfo();
  /**
   * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
   * @return The clientinfo.
   */
  io.emqx.exhook.ClientInfo getClientinfo();
  /**
   * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
   */
  io.emqx.exhook.ClientInfoOrBuilder getClientinfoOrBuilder();

  /**
   * <code>string topic = 2;</code>
   * @return The topic.
   */
  String getTopic();
  /**
   * <code>string topic = 2;</code>
   * @return The bytes for topic.
   */
  com.google.protobuf.ByteString
      getTopicBytes();

  /**
   * <code>.emqx.exhook.v2.SubOpts subopts = 3;</code>
   * @return Whether the subopts field is set.
   */
  boolean hasSubopts();
  /**
   * <code>.emqx.exhook.v2.SubOpts subopts = 3;</code>
   * @return The subopts.
   */
  io.emqx.exhook.SubOpts getSubopts();
  /**
   * <code>.emqx.exhook.v2.SubOpts subopts = 3;</code>
   */
  io.emqx.exhook.SubOptsOrBuilder getSuboptsOrBuilder();

  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 4;</code>
   * @return Whether the meta field is set.
   */
  boolean hasMeta();
  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 4;</code>
   * @return The meta.
   */
  io.emqx.exhook.RequestMeta getMeta();
  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 4;</code>
   */
  io.emqx.exhook.RequestMetaOrBuilder getMetaOrBuilder();
}
