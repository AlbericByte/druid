/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.druid.indexing.overlord;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import org.apache.druid.guice.annotations.PublicApi;

import java.util.List;


/**
 * A snapshot of all Worker and its current state.
 */
@PublicApi
public class CategoryCapacityInfo
{
  private final List<String> taskTypeList;
  private final int capacity;

  @JsonCreator
  public CategoryCapacityInfo(
      @JsonProperty("taskType") List<String> taskTypeList,
      @JsonProperty("capacity") int capacity
  )
  {
    this.taskTypeList = taskTypeList;
    this.capacity = capacity;
  }

  @JsonProperty("taskType")
  public List<String> getTaskTypeList()
  {
    return taskTypeList;
  }

  @JsonProperty("capacity")
  public int getCapacity()
  {
    return capacity;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CategoryCapacityInfo that = (CategoryCapacityInfo) o;

    if (!taskTypeList.equals(that.taskTypeList)) {
      return false;
    }
    if (capacity != that.capacity) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode()
  {
    return Objects.hashCode(taskTypeList, capacity);
  }

  @Override
  public String toString()
  {
    return "CapacityInfo{" +
           ", taskTypeList=" + taskTypeList.toString() +
           ", capacity=" + capacity;
  }
}