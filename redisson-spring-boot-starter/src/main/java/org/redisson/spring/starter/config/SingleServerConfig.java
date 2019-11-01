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

/**
 *
 * @author Nikita Koksharov
 *
 */
public class SingleServerConfig extends BaseConfig<SingleServerConfig> {

    /**
     * Redis server address
     *
     */
    private String address;

    /**
     * Minimum idle subscription connection amount
     */
    private int subscriptionConnectionMinimumIdleSize = 1;

    /**
     * Redis subscription connection maximum pool size
     *
     */
    private int subscriptionConnectionPoolSize = 50;

    /**
     * Minimum idle Redis connection amount
     */
    private int connectionMinimumIdleSize = 24;

    /**
     * Redis connection maximum pool size
     */
    private int connectionPoolSize = 64;

    /**
     * Database index used for Redis connection
     */
    private int database = 0;

    /**
     * Interval in milliseconds to check DNS
     */
    private long dnsMonitoringInterval = 5000;

    public String getAddress() {
        return address;
    }

    /**
     * Set server address. Use follow format -- host:port
     *
     * @param address of Redis
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public int getSubscriptionConnectionMinimumIdleSize() {
        return subscriptionConnectionMinimumIdleSize;
    }

    /**
     * Minimum idle subscription connection amount.
     * <p>
     * Default is 1
     *
     * @param subscriptionConnectionMinimumIdleSize - connections amount
     *
     */
    public void setSubscriptionConnectionMinimumIdleSize(
            int subscriptionConnectionMinimumIdleSize) {
        this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
    }

    public int getSubscriptionConnectionPoolSize() {
        return subscriptionConnectionPoolSize;
    }

    /**
     * Redis subscription-connection pool size limit
     * <p>
     * Default is 50
     *
     * @param subscriptionConnectionPoolSize - pool size
     */
    public void setSubscriptionConnectionPoolSize(int subscriptionConnectionPoolSize) {
        this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
    }

    public int getConnectionMinimumIdleSize() {
        return connectionMinimumIdleSize;
    }

    /**
     * Minimum idle Redis connection amount.
     * <p>
     * Default is <code>10</code>
     *
     * @param connectionMinimumIdleSize - connections amount
     */
    public void setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
        this.connectionMinimumIdleSize = connectionMinimumIdleSize;
    }

    public int getConnectionPoolSize() {
        return connectionPoolSize;
    }

    /**
     * Redis connection pool size
     * <p>
     * Default is <code>64</code>
     *
     * @param connectionPoolSize - pool size
     */
    public void setConnectionPoolSize(int connectionPoolSize) {
        this.connectionPoolSize = connectionPoolSize;
    }

    public int getDatabase() {
        return database;
    }

    /**
     * Database index used for Redis connection
     * Default is <code>0</code>
     *
     * @param database index
     */
    public void setDatabase(int database) {
        this.database = database;
    }

    public long getDnsMonitoringInterval() {
        return dnsMonitoringInterval;
    }

    /**
     * Interval in milliseconds to check the endpoint's DNS<p>
     * Applications must ensure the JVM DNS cache TTL is low enough to support this.<p>
     * Set <code>-1</code> to disable.
     * <p>
     * Default is <code>5000</code>.
     *
     * @param dnsMonitoringInterval time
     */
    public void setDnsMonitoringInterval(long dnsMonitoringInterval) {
        this.dnsMonitoringInterval = dnsMonitoringInterval;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SingleServerConfig{");
        sb.append("address='").append(address).append('\'');
        sb.append(", subscriptionConnectionMinimumIdleSize=").append(subscriptionConnectionMinimumIdleSize);
        sb.append(", subscriptionConnectionPoolSize=").append(subscriptionConnectionPoolSize);
        sb.append(", connectionMinimumIdleSize=").append(connectionMinimumIdleSize);
        sb.append(", connectionPoolSize=").append(connectionPoolSize);
        sb.append(", database=").append(database);
        sb.append(", dnsMonitoringInterval=").append(dnsMonitoringInterval);
        sb.append('}');
        return sb.toString();
    }
}
