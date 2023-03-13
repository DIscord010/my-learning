// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: exhook.proto

package io.emqx.exhook;

/**
 * Protobuf type {@code emqx.exhook.v2.MessageAckedRequest}
 */
public final class MessageAckedRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:emqx.exhook.v2.MessageAckedRequest)
        MessageAckedRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MessageAckedRequest.newBuilder() to construct.
  private MessageAckedRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageAckedRequest() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new MessageAckedRequest();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_MessageAckedRequest_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_MessageAckedRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.emqx.exhook.MessageAckedRequest.class, io.emqx.exhook.MessageAckedRequest.Builder.class);
  }

  public static final int CLIENTINFO_FIELD_NUMBER = 1;
  private io.emqx.exhook.ClientInfo clientinfo_;
  /**
   * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
   * @return Whether the clientinfo field is set.
   */
  @Override
  public boolean hasClientinfo() {
    return clientinfo_ != null;
  }
  /**
   * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
   * @return The clientinfo.
   */
  @Override
  public io.emqx.exhook.ClientInfo getClientinfo() {
    return clientinfo_ == null ? io.emqx.exhook.ClientInfo.getDefaultInstance() : clientinfo_;
  }
  /**
   * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
   */
  @Override
  public io.emqx.exhook.ClientInfoOrBuilder getClientinfoOrBuilder() {
    return getClientinfo();
  }

  public static final int MESSAGE_FIELD_NUMBER = 2;
  private io.emqx.exhook.Message message_;
  /**
   * <code>.emqx.exhook.v2.Message message = 2;</code>
   * @return Whether the message field is set.
   */
  @Override
  public boolean hasMessage() {
    return message_ != null;
  }
  /**
   * <code>.emqx.exhook.v2.Message message = 2;</code>
   * @return The message.
   */
  @Override
  public io.emqx.exhook.Message getMessage() {
    return message_ == null ? io.emqx.exhook.Message.getDefaultInstance() : message_;
  }
  /**
   * <code>.emqx.exhook.v2.Message message = 2;</code>
   */
  @Override
  public io.emqx.exhook.MessageOrBuilder getMessageOrBuilder() {
    return getMessage();
  }

  public static final int META_FIELD_NUMBER = 3;
  private io.emqx.exhook.RequestMeta meta_;
  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
   * @return Whether the meta field is set.
   */
  @Override
  public boolean hasMeta() {
    return meta_ != null;
  }
  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
   * @return The meta.
   */
  @Override
  public io.emqx.exhook.RequestMeta getMeta() {
    return meta_ == null ? io.emqx.exhook.RequestMeta.getDefaultInstance() : meta_;
  }
  /**
   * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
   */
  @Override
  public io.emqx.exhook.RequestMetaOrBuilder getMetaOrBuilder() {
    return getMeta();
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (clientinfo_ != null) {
      output.writeMessage(1, getClientinfo());
    }
    if (message_ != null) {
      output.writeMessage(2, getMessage());
    }
    if (meta_ != null) {
      output.writeMessage(3, getMeta());
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (clientinfo_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getClientinfo());
    }
    if (message_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getMessage());
    }
    if (meta_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getMeta());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.emqx.exhook.MessageAckedRequest)) {
      return super.equals(obj);
    }
    io.emqx.exhook.MessageAckedRequest other = (io.emqx.exhook.MessageAckedRequest) obj;

    if (hasClientinfo() != other.hasClientinfo()) return false;
    if (hasClientinfo()) {
      if (!getClientinfo()
          .equals(other.getClientinfo())) return false;
    }
    if (hasMessage() != other.hasMessage()) return false;
    if (hasMessage()) {
      if (!getMessage()
          .equals(other.getMessage())) return false;
    }
    if (hasMeta() != other.hasMeta()) return false;
    if (hasMeta()) {
      if (!getMeta()
          .equals(other.getMeta())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasClientinfo()) {
      hash = (37 * hash) + CLIENTINFO_FIELD_NUMBER;
      hash = (53 * hash) + getClientinfo().hashCode();
    }
    if (hasMessage()) {
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
    }
    if (hasMeta()) {
      hash = (37 * hash) + META_FIELD_NUMBER;
      hash = (53 * hash) + getMeta().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.emqx.exhook.MessageAckedRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.emqx.exhook.MessageAckedRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.emqx.exhook.MessageAckedRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.emqx.exhook.MessageAckedRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.emqx.exhook.MessageAckedRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code emqx.exhook.v2.MessageAckedRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:emqx.exhook.v2.MessageAckedRequest)
      MessageAckedRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_MessageAckedRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_MessageAckedRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.emqx.exhook.MessageAckedRequest.class, io.emqx.exhook.MessageAckedRequest.Builder.class);
    }

    // Construct using io.emqx.exhook.MessageAckedRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        BuilderParent parent) {
      super(parent);

    }
    @Override
    public Builder clear() {
      super.clear();
      if (clientinfoBuilder_ == null) {
        clientinfo_ = null;
      } else {
        clientinfo_ = null;
        clientinfoBuilder_ = null;
      }
      if (messageBuilder_ == null) {
        message_ = null;
      } else {
        message_ = null;
        messageBuilder_ = null;
      }
      if (metaBuilder_ == null) {
        meta_ = null;
      } else {
        meta_ = null;
        metaBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_MessageAckedRequest_descriptor;
    }

    @Override
    public io.emqx.exhook.MessageAckedRequest getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    @Override
    public io.emqx.exhook.MessageAckedRequest build() {
      io.emqx.exhook.MessageAckedRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public io.emqx.exhook.MessageAckedRequest buildPartial() {
      io.emqx.exhook.MessageAckedRequest result = new io.emqx.exhook.MessageAckedRequest(this);
      if (clientinfoBuilder_ == null) {
        result.clientinfo_ = clientinfo_;
      } else {
        result.clientinfo_ = clientinfoBuilder_.build();
      }
      if (messageBuilder_ == null) {
        result.message_ = message_;
      } else {
        result.message_ = messageBuilder_.build();
      }
      if (metaBuilder_ == null) {
        result.meta_ = meta_;
      } else {
        result.meta_ = metaBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.emqx.exhook.MessageAckedRequest) {
        return mergeFrom((io.emqx.exhook.MessageAckedRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.emqx.exhook.MessageAckedRequest other) {
      if (other == getDefaultInstance()) return this;
      if (other.hasClientinfo()) {
        mergeClientinfo(other.getClientinfo());
      }
      if (other.hasMessage()) {
        mergeMessage(other.getMessage());
      }
      if (other.hasMeta()) {
        mergeMeta(other.getMeta());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getClientinfoFieldBuilder().getBuilder(),
                  extensionRegistry);

              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getMessageFieldBuilder().getBuilder(),
                  extensionRegistry);

              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getMetaFieldBuilder().getBuilder(),
                  extensionRegistry);

              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private io.emqx.exhook.ClientInfo clientinfo_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.emqx.exhook.ClientInfo, io.emqx.exhook.ClientInfo.Builder, io.emqx.exhook.ClientInfoOrBuilder> clientinfoBuilder_;
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     * @return Whether the clientinfo field is set.
     */
    public boolean hasClientinfo() {
      return clientinfoBuilder_ != null || clientinfo_ != null;
    }
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     * @return The clientinfo.
     */
    public io.emqx.exhook.ClientInfo getClientinfo() {
      if (clientinfoBuilder_ == null) {
        return clientinfo_ == null ? io.emqx.exhook.ClientInfo.getDefaultInstance() : clientinfo_;
      } else {
        return clientinfoBuilder_.getMessage();
      }
    }
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     */
    public Builder setClientinfo(io.emqx.exhook.ClientInfo value) {
      if (clientinfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        clientinfo_ = value;
        onChanged();
      } else {
        clientinfoBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     */
    public Builder setClientinfo(
        io.emqx.exhook.ClientInfo.Builder builderForValue) {
      if (clientinfoBuilder_ == null) {
        clientinfo_ = builderForValue.build();
        onChanged();
      } else {
        clientinfoBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     */
    public Builder mergeClientinfo(io.emqx.exhook.ClientInfo value) {
      if (clientinfoBuilder_ == null) {
        if (clientinfo_ != null) {
          clientinfo_ =
            io.emqx.exhook.ClientInfo.newBuilder(clientinfo_).mergeFrom(value).buildPartial();
        } else {
          clientinfo_ = value;
        }
        onChanged();
      } else {
        clientinfoBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     */
    public Builder clearClientinfo() {
      if (clientinfoBuilder_ == null) {
        clientinfo_ = null;
        onChanged();
      } else {
        clientinfo_ = null;
        clientinfoBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     */
    public io.emqx.exhook.ClientInfo.Builder getClientinfoBuilder() {
      
      onChanged();
      return getClientinfoFieldBuilder().getBuilder();
    }
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     */
    public io.emqx.exhook.ClientInfoOrBuilder getClientinfoOrBuilder() {
      if (clientinfoBuilder_ != null) {
        return clientinfoBuilder_.getMessageOrBuilder();
      } else {
        return clientinfo_ == null ?
            io.emqx.exhook.ClientInfo.getDefaultInstance() : clientinfo_;
      }
    }
    /**
     * <code>.emqx.exhook.v2.ClientInfo clientinfo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.emqx.exhook.ClientInfo, io.emqx.exhook.ClientInfo.Builder, io.emqx.exhook.ClientInfoOrBuilder> 
        getClientinfoFieldBuilder() {
      if (clientinfoBuilder_ == null) {
        clientinfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.emqx.exhook.ClientInfo, io.emqx.exhook.ClientInfo.Builder, io.emqx.exhook.ClientInfoOrBuilder>(
                getClientinfo(),
                getParentForChildren(),
                isClean());
        clientinfo_ = null;
      }
      return clientinfoBuilder_;
    }

    private io.emqx.exhook.Message message_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.emqx.exhook.Message, io.emqx.exhook.Message.Builder, io.emqx.exhook.MessageOrBuilder> messageBuilder_;
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     * @return Whether the message field is set.
     */
    public boolean hasMessage() {
      return messageBuilder_ != null || message_ != null;
    }
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     * @return The message.
     */
    public io.emqx.exhook.Message getMessage() {
      if (messageBuilder_ == null) {
        return message_ == null ? io.emqx.exhook.Message.getDefaultInstance() : message_;
      } else {
        return messageBuilder_.getMessage();
      }
    }
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     */
    public Builder setMessage(io.emqx.exhook.Message value) {
      if (messageBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        message_ = value;
        onChanged();
      } else {
        messageBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     */
    public Builder setMessage(
        io.emqx.exhook.Message.Builder builderForValue) {
      if (messageBuilder_ == null) {
        message_ = builderForValue.build();
        onChanged();
      } else {
        messageBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     */
    public Builder mergeMessage(io.emqx.exhook.Message value) {
      if (messageBuilder_ == null) {
        if (message_ != null) {
          message_ =
            io.emqx.exhook.Message.newBuilder(message_).mergeFrom(value).buildPartial();
        } else {
          message_ = value;
        }
        onChanged();
      } else {
        messageBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     */
    public Builder clearMessage() {
      if (messageBuilder_ == null) {
        message_ = null;
        onChanged();
      } else {
        message_ = null;
        messageBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     */
    public io.emqx.exhook.Message.Builder getMessageBuilder() {
      
      onChanged();
      return getMessageFieldBuilder().getBuilder();
    }
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     */
    public io.emqx.exhook.MessageOrBuilder getMessageOrBuilder() {
      if (messageBuilder_ != null) {
        return messageBuilder_.getMessageOrBuilder();
      } else {
        return message_ == null ?
            io.emqx.exhook.Message.getDefaultInstance() : message_;
      }
    }
    /**
     * <code>.emqx.exhook.v2.Message message = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.emqx.exhook.Message, io.emqx.exhook.Message.Builder, io.emqx.exhook.MessageOrBuilder> 
        getMessageFieldBuilder() {
      if (messageBuilder_ == null) {
        messageBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.emqx.exhook.Message, io.emqx.exhook.Message.Builder, io.emqx.exhook.MessageOrBuilder>(
                getMessage(),
                getParentForChildren(),
                isClean());
        message_ = null;
      }
      return messageBuilder_;
    }

    private io.emqx.exhook.RequestMeta meta_;
    private com.google.protobuf.SingleFieldBuilderV3<
        io.emqx.exhook.RequestMeta, io.emqx.exhook.RequestMeta.Builder, io.emqx.exhook.RequestMetaOrBuilder> metaBuilder_;
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     * @return Whether the meta field is set.
     */
    public boolean hasMeta() {
      return metaBuilder_ != null || meta_ != null;
    }
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     * @return The meta.
     */
    public io.emqx.exhook.RequestMeta getMeta() {
      if (metaBuilder_ == null) {
        return meta_ == null ? io.emqx.exhook.RequestMeta.getDefaultInstance() : meta_;
      } else {
        return metaBuilder_.getMessage();
      }
    }
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     */
    public Builder setMeta(io.emqx.exhook.RequestMeta value) {
      if (metaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        meta_ = value;
        onChanged();
      } else {
        metaBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     */
    public Builder setMeta(
        io.emqx.exhook.RequestMeta.Builder builderForValue) {
      if (metaBuilder_ == null) {
        meta_ = builderForValue.build();
        onChanged();
      } else {
        metaBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     */
    public Builder mergeMeta(io.emqx.exhook.RequestMeta value) {
      if (metaBuilder_ == null) {
        if (meta_ != null) {
          meta_ =
            io.emqx.exhook.RequestMeta.newBuilder(meta_).mergeFrom(value).buildPartial();
        } else {
          meta_ = value;
        }
        onChanged();
      } else {
        metaBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     */
    public Builder clearMeta() {
      if (metaBuilder_ == null) {
        meta_ = null;
        onChanged();
      } else {
        meta_ = null;
        metaBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     */
    public io.emqx.exhook.RequestMeta.Builder getMetaBuilder() {
      
      onChanged();
      return getMetaFieldBuilder().getBuilder();
    }
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     */
    public io.emqx.exhook.RequestMetaOrBuilder getMetaOrBuilder() {
      if (metaBuilder_ != null) {
        return metaBuilder_.getMessageOrBuilder();
      } else {
        return meta_ == null ?
            io.emqx.exhook.RequestMeta.getDefaultInstance() : meta_;
      }
    }
    /**
     * <code>.emqx.exhook.v2.RequestMeta meta = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        io.emqx.exhook.RequestMeta, io.emqx.exhook.RequestMeta.Builder, io.emqx.exhook.RequestMetaOrBuilder> 
        getMetaFieldBuilder() {
      if (metaBuilder_ == null) {
        metaBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            io.emqx.exhook.RequestMeta, io.emqx.exhook.RequestMeta.Builder, io.emqx.exhook.RequestMetaOrBuilder>(
                getMeta(),
                getParentForChildren(),
                isClean());
        meta_ = null;
      }
      return metaBuilder_;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:emqx.exhook.v2.MessageAckedRequest)
  }

  // @@protoc_insertion_point(class_scope:emqx.exhook.v2.MessageAckedRequest)
  private static final io.emqx.exhook.MessageAckedRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.emqx.exhook.MessageAckedRequest();
  }

  public static io.emqx.exhook.MessageAckedRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageAckedRequest>
      PARSER = new com.google.protobuf.AbstractParser<MessageAckedRequest>() {
    @Override
    public MessageAckedRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<MessageAckedRequest> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<MessageAckedRequest> getParserForType() {
    return PARSER;
  }

  @Override
  public io.emqx.exhook.MessageAckedRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

