/**
 * Copyright (c) 2013-2019 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.spring.starter.config;

import org.redisson.codec.FstCodec;
import org.redisson.config.TransportMode;
import org.redisson.connection.DnsAddressResolverGroupFactory;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Redisson configuration
 *
 * @author Nikita Koksharov
 *
 */
public class Config {

    @NestedConfigurationProperty
    private SentinelServersConfig sentinelServersConfig;

    @NestedConfigurationProperty
    private MasterSlaveServersConfig masterSlaveServersConfig;

    @NestedConfigurationProperty
    private SingleServerConfig singleServerConfig;

    @NestedConfigurationProperty
    private ClusterServersConfig clusterServersConfig;

    @NestedConfigurationProperty
    private ReplicatedServersConfig replicatedServersConfig;

//    private ConnectionManager connectionManager;

    /**
     * Threads amount shared between all redis node clients
     */
    private int threads = 16;

    private int nettyThreads = 32;

    /**
     * Redis key/value codec. FST codec is used by default
     */
    @NestedConfigurationProperty
    private ClassProperty codec = new ClassProperty(FstCodec.class.getName());

//    private ExecutorService executor;

    /**
     * Config option for enabling Redisson Reference feature.
     * Default value is TRUE
     */
    private boolean referenceEnabled = true;

    private TransportMode transportMode = TransportMode.NIO;

//    private EventLoopGroup eventLoopGroup;

    private long lockWatchdogTimeout = 30 * 1000;

    private boolean keepPubSubOrder = true;

    private boolean decodeInExecutor = false;

    private boolean useScriptCache = false;

    private int minCleanUpDelay = 5;
    private int maxCleanUpDelay = 30 * 60;

    /**
     * AddressResolverGroupFactory switch between default and round robin
     */
    @NestedConfigurationProperty
    private ClassProperty addressResolverGroupFactory = new ClassProperty(
            DnsAddressResolverGroupFactory.class.getName());

    public SentinelServersConfig getSentinelServersConfig() {
        return sentinelServersConfig;
    }

    public void setSentinelServersConfig(SentinelServersConfig sentinelServersConfig) {
        this.sentinelServersConfig = sentinelServersConfig;
    }

    public MasterSlaveServersConfig getMasterSlaveServersConfig() {
        return masterSlaveServersConfig;
    }

    public void setMasterSlaveServersConfig(MasterSlaveServersConfig masterSlaveServersConfig) {
        this.masterSlaveServersConfig = masterSlaveServersConfig;
    }

    public SingleServerConfig getSingleServerConfig() {
        return singleServerConfig;
    }

    public void setSingleServerConfig(SingleServerConfig singleServerConfig) {
        this.singleServerConfig = singleServerConfig;
    }

    public ClusterServersConfig getClusterServersConfig() {
        return clusterServersConfig;
    }

    public void setClusterServersConfig(ClusterServersConfig clusterServersConfig) {
        this.clusterServersConfig = clusterServersConfig;
    }

    public ReplicatedServersConfig getReplicatedServersConfig() {
        return replicatedServersConfig;
    }

    public void setReplicatedServersConfig(ReplicatedServersConfig replicatedServersConfig) {
        this.replicatedServersConfig = replicatedServersConfig;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public int getNettyThreads() {
        return nettyThreads;
    }

    public void setNettyThreads(int nettyThreads) {
        this.nettyThreads = nettyThreads;
    }

    public ClassProperty getCodec() {
        return codec;
    }

    public void setCodec(ClassProperty codec) {
        this.codec = codec;
    }

    public boolean isReferenceEnabled() {
        return referenceEnabled;
    }

    public void setReferenceEnabled(boolean referenceEnabled) {
        this.referenceEnabled = referenceEnabled;
    }

    public TransportMode getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(TransportMode transportMode) {
        this.transportMode = transportMode;
    }

    public long getLockWatchdogTimeout() {
        return lockWatchdogTimeout;
    }

    public void setLockWatchdogTimeout(long lockWatchdogTimeout) {
        this.lockWatchdogTimeout = lockWatchdogTimeout;
    }

    public boolean isKeepPubSubOrder() {
        return keepPubSubOrder;
    }

    public void setKeepPubSubOrder(boolean keepPubSubOrder) {
        this.keepPubSubOrder = keepPubSubOrder;
    }

    public boolean isDecodeInExecutor() {
        return decodeInExecutor;
    }

    public void setDecodeInExecutor(boolean decodeInExecutor) {
        this.decodeInExecutor = decodeInExecutor;
    }

    public boolean isUseScriptCache() {
        return useScriptCache;
    }

    public void setUseScriptCache(boolean useScriptCache) {
        this.useScriptCache = useScriptCache;
    }

    public int getMinCleanUpDelay() {
        return minCleanUpDelay;
    }

    public void setMinCleanUpDelay(int minCleanUpDelay) {
        this.minCleanUpDelay = minCleanUpDelay;
    }

    public int getMaxCleanUpDelay() {
        return maxCleanUpDelay;
    }

    public void setMaxCleanUpDelay(int maxCleanUpDelay) {
        this.maxCleanUpDelay = maxCleanUpDelay;
    }

    public ClassProperty getAddressResolverGroupFactory() {
        return addressResolverGroupFactory;
    }

    public void setAddressResolverGroupFactory(ClassProperty addressResolverGroupFactory) {
        this.addressResolverGroupFactory = addressResolverGroupFactory;
    }
}
