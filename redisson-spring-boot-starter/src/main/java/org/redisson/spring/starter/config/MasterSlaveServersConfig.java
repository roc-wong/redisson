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

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Nikita Koksharov
 *
 */
public class MasterSlaveServersConfig extends
        BaseMasterSlaveServersConfig<MasterSlaveServersConfig> {

    /**
     * Redis slave servers addresses
     */
    private Set<String> slaveAddresses = new HashSet<String>();

    /**
     * Redis master server address
     */
    private String masterAddress;

    /**
     * Database index used for Redis connection
     */
    private int database = 0;

    public Set<String> getSlaveAddresses() {
        return slaveAddresses;
    }

    public void setSlaveAddresses(Set<String> slaveAddresses) {
        this.slaveAddresses = slaveAddresses;
    }

    public String getMasterAddress() {
        return masterAddress;
    }

    public void setMasterAddress(String masterAddress) {
        this.masterAddress = masterAddress;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }
}
