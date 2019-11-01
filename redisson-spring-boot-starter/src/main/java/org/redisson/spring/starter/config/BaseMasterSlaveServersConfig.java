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

import org.redisson.config.ReadMode;
import org.redisson.config.SubscriptionMode;
import org.redisson.connection.balancer.RoundRobinLoadBalancer;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @param <T> config type
 * @author Nikita Koksharov
 */
public class BaseMasterSlaveServersConfig<T extends BaseMasterSlaveServersConfig<T>> extends
        BaseConfig<T> {

    /**
     * Сonnection load balancer for multiple Redis slave servers
     */
    @NestedConfigurationProperty
    private ClassProperty loadBalancer = new ClassProperty(RoundRobinLoadBalancer.class.getName());

    /**
     * Redis 'slave' node minimum idle connection amount for <b>each</b> slave node
     */
    private int slaveConnectionMinimumIdleSize = 24;

    /**
     * Redis 'slave' node maximum connection pool size for <b>each</b> slave node
     */
    private int slaveConnectionPoolSize = 64;

    private int failedSlaveReconnectionInterval = 3000;

    private int failedSlaveCheckInterval = 180000;

    /**
     * Redis 'master' node minimum idle connection amount for <b>each</b> slave node
     */
    private int masterConnectionMinimumIdleSize = 24;

    /**
     * Redis 'master' node maximum connection pool size
     */
    private int masterConnectionPoolSize = 64;

    private ReadMode readMode = ReadMode.SLAVE;

    private SubscriptionMode subscriptionMode = SubscriptionMode.MASTER;

    /**
     * Redis 'slave' node minimum idle subscription (pub/sub) connection amount for <b>each</b>
     * slave node
     */
    private int subscriptionConnectionMinimumIdleSize = 1;

    /**
     * Redis 'slave' node maximum subscription (pub/sub) connection pool size for <b>each</b> slave
     * node
     */
    private int subscriptionConnectionPoolSize = 50;

    private long dnsMonitoringInterval = 5000;

    public BaseMasterSlaveServersConfig() {
    }

    public ClassProperty getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * Сonnection load balancer to multiple Redis slave servers. Uses Round-robin algorithm by
     * default
     *
     * @param loadBalancer object
     * @see org.redisson.connection.balancer.RandomLoadBalancer
     * @see org.redisson.connection.balancer.RoundRobinLoadBalancer
     * @see org.redisson.connection.balancer.WeightedRoundRobinBalancer
     */
    public void setLoadBalancer(ClassProperty loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public int getSlaveConnectionMinimumIdleSize() {
        return slaveConnectionMinimumIdleSize;
    }

    /**
     * Minimum idle connection pool size for subscription (pub/sub) channels
     * <p>
     * Default is <code>10</code>
     * <p>
     *
     * @param slaveConnectionMinimumIdleSize - pool size
     * @see #setSlaveConnectionPoolSize(int)
     */
    public void setSlaveConnectionMinimumIdleSize(int slaveConnectionMinimumIdleSize) {
        this.slaveConnectionMinimumIdleSize = slaveConnectionMinimumIdleSize;
    }

    public int getSlaveConnectionPoolSize() {
        return slaveConnectionPoolSize;
    }

    /**
     * Redis 'slave' servers connection pool size for <b>each</b> slave node.
     * <p>
     * Default is <code>64</code>
     * <p>
     *
     * @param slaveConnectionPoolSize - size of pool
     * @see #setSlaveConnectionMinimumIdleSize(int)
     */
    public void setSlaveConnectionPoolSize(int slaveConnectionPoolSize) {
        this.slaveConnectionPoolSize = slaveConnectionPoolSize;
    }

    public int getFailedSlaveReconnectionInterval() {
        return failedSlaveReconnectionInterval;
    }

    /**
     * Interval of Redis Slave reconnection attempt when it was excluded from internal list of
     * available servers.
     * <p>
     * On every such timeout event Redisson tries to connect to disconnected Redis server.
     * <p>
     * Default is 3000
     *
     * @param failedSlaveReconnectionInterval - retry timeout in milliseconds
     */
    public void setFailedSlaveReconnectionInterval(int failedSlaveReconnectionInterval) {
        this.failedSlaveReconnectionInterval = failedSlaveReconnectionInterval;
    }

    public int getFailedSlaveCheckInterval() {
        return failedSlaveCheckInterval;
    }

    /**
     * Redis Slave node failing to execute commands is excluded from the internal list of available
     * nodes when the time interval from the moment of first Redis command execution failure on this
     * server reaches <code>slaveFailsInterval</code> value.
     * <p>
     * Default is <code>180000</code>
     *
     * @param failedSlaveCheckInterval - time interval in milliseconds
     */
    public void setFailedSlaveCheckInterval(int failedSlaveCheckInterval) {
        this.failedSlaveCheckInterval = failedSlaveCheckInterval;
    }

    public int getMasterConnectionMinimumIdleSize() {
        return masterConnectionMinimumIdleSize;
    }

    /**
     * Redis 'master' node minimum idle connection amount for <b>each</b> slave node
     * <p>
     * Default is <code>10</code>
     * <p>
     *
     * @param masterConnectionMinimumIdleSize - pool size
     * @see #setMasterConnectionPoolSize(int)
     */
    public void setMasterConnectionMinimumIdleSize(int masterConnectionMinimumIdleSize) {
        this.masterConnectionMinimumIdleSize = masterConnectionMinimumIdleSize;
    }

    public int getMasterConnectionPoolSize() {
        return masterConnectionPoolSize;
    }

    /**
     * Redis 'master' server connection pool size.
     * <p>
     * Default is <code>64</code>
     *
     * @param masterConnectionPoolSize - pool size
     * @see #setMasterConnectionMinimumIdleSize(int)
     */
    public void setMasterConnectionPoolSize(int masterConnectionPoolSize) {
        this.masterConnectionPoolSize = masterConnectionPoolSize;
    }

    public ReadMode getReadMode() {
        return readMode;
    }

    /**
     * Set node type used for read operation.
     * <p>
     * Default is <code>SLAVE</code>
     *
     * @param readMode param
     */
    public void setReadMode(ReadMode readMode) {
        this.readMode = readMode;
    }

    public SubscriptionMode getSubscriptionMode() {
        return subscriptionMode;
    }

    /**
     * Set node type used for subscription operation.
     * <p>
     * Default is <code>MASTER</code>
     *
     * @param subscriptionMode param
     */
    public void setSubscriptionMode(SubscriptionMode subscriptionMode) {
        this.subscriptionMode = subscriptionMode;
    }

    public int getSubscriptionConnectionMinimumIdleSize() {
        return subscriptionConnectionMinimumIdleSize;
    }

    /**
     * Redis 'slave' node minimum idle subscription (pub/sub) connection amount for <b>each</b>
     * slave node.
     * <p>
     * Default is <code>1</code>
     * <p>
     *
     * @param subscriptionConnectionMinimumIdleSize - pool size
     * @see #setSubscriptionConnectionPoolSize(int)
     */
    public void setSubscriptionConnectionMinimumIdleSize(
            int subscriptionConnectionMinimumIdleSize) {
        this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
    }

    public int getSubscriptionConnectionPoolSize() {
        return subscriptionConnectionPoolSize;
    }

    /**
     * Maximum connection pool size for subscription (pub/sub) channels
     * <p>
     * Default is <code>50</code>
     * <p>
     *
     * @param subscriptionConnectionPoolSize - pool size
     * @see #setSubscriptionConnectionMinimumIdleSize(int)
     */
    public void setSubscriptionConnectionPoolSize(int subscriptionConnectionPoolSize) {
        this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
    }

    public long getDnsMonitoringInterval() {
        return dnsMonitoringInterval;
    }

    /**
     * Interval in milliseconds to check the endpoint's DNS<p> Applications must ensure the JVM DNS
     * cache TTL is low enough to support this.<p> Set <code>-1</code> to disable.
     * <p>
     * Default is <code>5000</code>.
     *
     * @param dnsMonitoringInterval time
     */
    public void setDnsMonitoringInterval(long dnsMonitoringInterval) {
        this.dnsMonitoringInterval = dnsMonitoringInterval;
    }

    @Deprecated
    public int getSlaveSubscriptionConnectionPoolSize() {
        return getSubscriptionConnectionPoolSize();
    }

    /**
     * @param slaveSubscriptionConnectionPoolSize - pool size
     * @deprecated use {@link #setSubscriptionConnectionPoolSize(int)}
     */
    @Deprecated
    public void setSlaveSubscriptionConnectionPoolSize(int slaveSubscriptionConnectionPoolSize) {
        setSubscriptionConnectionPoolSize(slaveSubscriptionConnectionPoolSize);
    }

    public boolean checkSkipSlavesInit() {
        return getReadMode() == ReadMode.MASTER && getSubscriptionMode() == SubscriptionMode.MASTER;
    }

    /**
     * @deprecated use {@link #setSubscriptionConnectionMinimumIdleSize(int)}
     *
     * @param slaveSubscriptionConnectionMinimumIdleSize - pool size
     */
    @Deprecated
    public void setSlaveSubscriptionConnectionMinimumIdleSize(int slaveSubscriptionConnectionMinimumIdleSize) {
        setSubscriptionConnectionMinimumIdleSize(slaveSubscriptionConnectionMinimumIdleSize);
    }
    @Deprecated
    public int getSlaveSubscriptionConnectionMinimumIdleSize() {
        return getSubscriptionConnectionMinimumIdleSize();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseMasterSlaveServersConfig{");
        sb.append("loadBalancer=").append(loadBalancer);
        sb.append(", slaveConnectionMinimumIdleSize=").append(slaveConnectionMinimumIdleSize);
        sb.append(", slaveConnectionPoolSize=").append(slaveConnectionPoolSize);
        sb.append(", failedSlaveReconnectionInterval=").append(failedSlaveReconnectionInterval);
        sb.append(", failedSlaveCheckInterval=").append(failedSlaveCheckInterval);
        sb.append(", masterConnectionMinimumIdleSize=").append(masterConnectionMinimumIdleSize);
        sb.append(", masterConnectionPoolSize=").append(masterConnectionPoolSize);
        sb.append(", readMode=").append(readMode);
        sb.append(", subscriptionMode=").append(subscriptionMode);
        sb.append(", subscriptionConnectionMinimumIdleSize=").append(subscriptionConnectionMinimumIdleSize);
        sb.append(", subscriptionConnectionPoolSize=").append(subscriptionConnectionPoolSize);
        sb.append(", dnsMonitoringInterval=").append(dnsMonitoringInterval);
        sb.append('}');
        return sb.toString();
    }
}
