// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: exhook.proto

package io.emqx.exhook;

public interface ClientUnsubscribeRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:emqx.exhook.v2.ClientUnsubscribeRequest)
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
   * <code>repeated .emqx.exhook.v2.Property props = 2;</code>
   */
  java.util.List<io.emqx.exhook.Property> 
      getPropsList();
  /**
   * <code>repeated .emqx.exhook.v2.Property props = 2;</code>
   */
  io.emqx.exhook.Property getProps(int index);
  /**
   * <code>repeated .emqx.exhook.v2.Property props = 2;</code>
   */
  int getPropsCount();
  /**
   * <code>repeated .emqx.exhook.v2.Property props = 2;</code>
   */
  java.util.List<? extends io.emqx.exhook.PropertyOrBuilder> 
      getPropsOrBuilderList();
  /**
   * <code>repeated .emqx.exhook.v2.Property props = 2;</code>
   */
  io.emqx.exhook.PropertyOrBuilder getPropsOrBuilder(
      int index);

  /**
   * <code>repeated .emqx.exhook.v2.TopicFilter topic_filters = 3;</code>
   */
  java.util.List<io.emqx.exhook.TopicFilter> 
      getTopicFiltersList();
  /**
   * <code>repeated .emqx.exhook.v2.TopicFilter topic_filters = 3;</code>
   */
  io.emqx.exhook.TopicFilter getTopicFilters(int index);
  /**
   * <code>repeated .emqx.exhook.v2.TopicFilter topic_filters = 3;</code>
   */
  int getTopicFiltersCount();
  /**
   * <code>repeated .emqx.exhook.v2.TopicFilter topic_filters = 3;</code>
   */
  java.util.List<? extends io.emqx.exhook.TopicFilterOrBuilder> 
      getTopicFiltersOrBuilderList();
  /**
   * <code>repeated .emqx.exhook.v2.TopicFilter topic_filters = 3;</code>
   */
  io.emqx.exhook.TopicFilterOrBuilder getTopicFiltersOrBuilder(
      int index);

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
