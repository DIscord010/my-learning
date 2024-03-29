// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: exhook.proto

package io.emqx.exhook;

/**
 * Protobuf type {@code emqx.exhook.v2.RequestMeta}
 */
public final class RequestMeta extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:emqx.exhook.v2.RequestMeta)
        RequestMetaOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestMeta.newBuilder() to construct.
  private RequestMeta(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestMeta() {
    node_ = "";
    version_ = "";
    sysdescr_ = "";
    clusterName_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new RequestMeta();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_RequestMeta_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_RequestMeta_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.emqx.exhook.RequestMeta.class, io.emqx.exhook.RequestMeta.Builder.class);
  }

  public static final int NODE_FIELD_NUMBER = 1;
  private volatile Object node_;
  /**
   * <code>string node = 1;</code>
   * @return The node.
   */
  @Override
  public String getNode() {
    Object ref = node_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      node_ = s;
      return s;
    }
  }
  /**
   * <code>string node = 1;</code>
   * @return The bytes for node.
   */
  @Override
  public com.google.protobuf.ByteString
      getNodeBytes() {
    Object ref = node_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      node_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VERSION_FIELD_NUMBER = 2;
  private volatile Object version_;
  /**
   * <code>string version = 2;</code>
   * @return The version.
   */
  @Override
  public String getVersion() {
    Object ref = version_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      version_ = s;
      return s;
    }
  }
  /**
   * <code>string version = 2;</code>
   * @return The bytes for version.
   */
  @Override
  public com.google.protobuf.ByteString
      getVersionBytes() {
    Object ref = version_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      version_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SYSDESCR_FIELD_NUMBER = 3;
  private volatile Object sysdescr_;
  /**
   * <code>string sysdescr = 3;</code>
   * @return The sysdescr.
   */
  @Override
  public String getSysdescr() {
    Object ref = sysdescr_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      sysdescr_ = s;
      return s;
    }
  }
  /**
   * <code>string sysdescr = 3;</code>
   * @return The bytes for sysdescr.
   */
  @Override
  public com.google.protobuf.ByteString
      getSysdescrBytes() {
    Object ref = sysdescr_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      sysdescr_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CLUSTER_NAME_FIELD_NUMBER = 4;
  private volatile Object clusterName_;
  /**
   * <code>string cluster_name = 4;</code>
   * @return The clusterName.
   */
  @Override
  public String getClusterName() {
    Object ref = clusterName_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      clusterName_ = s;
      return s;
    }
  }
  /**
   * <code>string cluster_name = 4;</code>
   * @return The bytes for clusterName.
   */
  @Override
  public com.google.protobuf.ByteString
      getClusterNameBytes() {
    Object ref = clusterName_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      clusterName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(node_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, node_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(version_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, version_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(sysdescr_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, sysdescr_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(clusterName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, clusterName_);
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(node_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, node_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(version_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, version_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(sysdescr_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, sysdescr_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(clusterName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, clusterName_);
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
    if (!(obj instanceof io.emqx.exhook.RequestMeta)) {
      return super.equals(obj);
    }
    io.emqx.exhook.RequestMeta other = (io.emqx.exhook.RequestMeta) obj;

    if (!getNode()
        .equals(other.getNode())) return false;
    if (!getVersion()
        .equals(other.getVersion())) return false;
    if (!getSysdescr()
        .equals(other.getSysdescr())) return false;
    if (!getClusterName()
        .equals(other.getClusterName())) return false;
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
    hash = (37 * hash) + NODE_FIELD_NUMBER;
    hash = (53 * hash) + getNode().hashCode();
    hash = (37 * hash) + VERSION_FIELD_NUMBER;
    hash = (53 * hash) + getVersion().hashCode();
    hash = (37 * hash) + SYSDESCR_FIELD_NUMBER;
    hash = (53 * hash) + getSysdescr().hashCode();
    hash = (37 * hash) + CLUSTER_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getClusterName().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.emqx.exhook.RequestMeta parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.emqx.exhook.RequestMeta parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.emqx.exhook.RequestMeta parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.emqx.exhook.RequestMeta parseFrom(
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
  public static Builder newBuilder(io.emqx.exhook.RequestMeta prototype) {
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
   * Protobuf type {@code emqx.exhook.v2.RequestMeta}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:emqx.exhook.v2.RequestMeta)
      RequestMetaOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_RequestMeta_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_RequestMeta_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.emqx.exhook.RequestMeta.class, io.emqx.exhook.RequestMeta.Builder.class);
    }

    // Construct using io.emqx.exhook.RequestMeta.newBuilder()
    private Builder() {

    }

    private Builder(
        BuilderParent parent) {
      super(parent);

    }
    @Override
    public Builder clear() {
      super.clear();
      node_ = "";

      version_ = "";

      sysdescr_ = "";

      clusterName_ = "";

      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.emqx.exhook.EmqxExHookProto.internal_static_emqx_exhook_v2_RequestMeta_descriptor;
    }

    @Override
    public io.emqx.exhook.RequestMeta getDefaultInstanceForType() {
      return getDefaultInstance();
    }

    @Override
    public io.emqx.exhook.RequestMeta build() {
      io.emqx.exhook.RequestMeta result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public io.emqx.exhook.RequestMeta buildPartial() {
      io.emqx.exhook.RequestMeta result = new io.emqx.exhook.RequestMeta(this);
      result.node_ = node_;
      result.version_ = version_;
      result.sysdescr_ = sysdescr_;
      result.clusterName_ = clusterName_;
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
      if (other instanceof io.emqx.exhook.RequestMeta) {
        return mergeFrom((io.emqx.exhook.RequestMeta)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.emqx.exhook.RequestMeta other) {
      if (other == getDefaultInstance()) return this;
      if (!other.getNode().isEmpty()) {
        node_ = other.node_;
        onChanged();
      }
      if (!other.getVersion().isEmpty()) {
        version_ = other.version_;
        onChanged();
      }
      if (!other.getSysdescr().isEmpty()) {
        sysdescr_ = other.sysdescr_;
        onChanged();
      }
      if (!other.getClusterName().isEmpty()) {
        clusterName_ = other.clusterName_;
        onChanged();
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
              node_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 18: {
              version_ = input.readStringRequireUtf8();

              break;
            } // case 18
            case 26: {
              sysdescr_ = input.readStringRequireUtf8();

              break;
            } // case 26
            case 34: {
              clusterName_ = input.readStringRequireUtf8();

              break;
            } // case 34
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

    private Object node_ = "";
    /**
     * <code>string node = 1;</code>
     * @return The node.
     */
    public String getNode() {
      Object ref = node_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        node_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string node = 1;</code>
     * @return The bytes for node.
     */
    public com.google.protobuf.ByteString
        getNodeBytes() {
      Object ref = node_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        node_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string node = 1;</code>
     * @param value The node to set.
     * @return This builder for chaining.
     */
    public Builder setNode(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      node_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string node = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearNode() {
      
      node_ = getDefaultInstance().getNode();
      onChanged();
      return this;
    }
    /**
     * <code>string node = 1;</code>
     * @param value The bytes for node to set.
     * @return This builder for chaining.
     */
    public Builder setNodeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      node_ = value;
      onChanged();
      return this;
    }

    private Object version_ = "";
    /**
     * <code>string version = 2;</code>
     * @return The version.
     */
    public String getVersion() {
      Object ref = version_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        version_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string version = 2;</code>
     * @return The bytes for version.
     */
    public com.google.protobuf.ByteString
        getVersionBytes() {
      Object ref = version_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        version_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string version = 2;</code>
     * @param value The version to set.
     * @return This builder for chaining.
     */
    public Builder setVersion(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      version_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string version = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearVersion() {
      
      version_ = getDefaultInstance().getVersion();
      onChanged();
      return this;
    }
    /**
     * <code>string version = 2;</code>
     * @param value The bytes for version to set.
     * @return This builder for chaining.
     */
    public Builder setVersionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      version_ = value;
      onChanged();
      return this;
    }

    private Object sysdescr_ = "";
    /**
     * <code>string sysdescr = 3;</code>
     * @return The sysdescr.
     */
    public String getSysdescr() {
      Object ref = sysdescr_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        sysdescr_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string sysdescr = 3;</code>
     * @return The bytes for sysdescr.
     */
    public com.google.protobuf.ByteString
        getSysdescrBytes() {
      Object ref = sysdescr_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        sysdescr_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string sysdescr = 3;</code>
     * @param value The sysdescr to set.
     * @return This builder for chaining.
     */
    public Builder setSysdescr(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      sysdescr_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string sysdescr = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearSysdescr() {
      
      sysdescr_ = getDefaultInstance().getSysdescr();
      onChanged();
      return this;
    }
    /**
     * <code>string sysdescr = 3;</code>
     * @param value The bytes for sysdescr to set.
     * @return This builder for chaining.
     */
    public Builder setSysdescrBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      sysdescr_ = value;
      onChanged();
      return this;
    }

    private Object clusterName_ = "";
    /**
     * <code>string cluster_name = 4;</code>
     * @return The clusterName.
     */
    public String getClusterName() {
      Object ref = clusterName_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        clusterName_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string cluster_name = 4;</code>
     * @return The bytes for clusterName.
     */
    public com.google.protobuf.ByteString
        getClusterNameBytes() {
      Object ref = clusterName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        clusterName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string cluster_name = 4;</code>
     * @param value The clusterName to set.
     * @return This builder for chaining.
     */
    public Builder setClusterName(
        String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      clusterName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string cluster_name = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearClusterName() {
      
      clusterName_ = getDefaultInstance().getClusterName();
      onChanged();
      return this;
    }
    /**
     * <code>string cluster_name = 4;</code>
     * @param value The bytes for clusterName to set.
     * @return This builder for chaining.
     */
    public Builder setClusterNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      clusterName_ = value;
      onChanged();
      return this;
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


    // @@protoc_insertion_point(builder_scope:emqx.exhook.v2.RequestMeta)
  }

  // @@protoc_insertion_point(class_scope:emqx.exhook.v2.RequestMeta)
  private static final io.emqx.exhook.RequestMeta DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.emqx.exhook.RequestMeta();
  }

  public static io.emqx.exhook.RequestMeta getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestMeta>
      PARSER = new com.google.protobuf.AbstractParser<RequestMeta>() {
    @Override
    public RequestMeta parsePartialFrom(
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

  public static com.google.protobuf.Parser<RequestMeta> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<RequestMeta> getParserForType() {
    return PARSER;
  }

  @Override
  public io.emqx.exhook.RequestMeta getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

