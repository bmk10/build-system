/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.builder.testing;

import com.android.annotations.NonNull;
import com.android.builder.testing.api.DeviceConnector;
import com.android.builder.testing.api.TestException;
import com.android.utils.ILogger;
import com.google.common.annotations.Beta;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/** A test runner able to run tests on a list of {@link DeviceConnector} */
@Beta
public interface TestRunner {

    /**
     * Returns true if the tests succeeded.
     *
     * @param timeoutInMs time out in milliseconds
     * @param installOptions parameters passed to the pm install command.
     * @return true if the test succeed
     */
    boolean runTests(
            @NonNull String projectName,
            @NonNull String variantName,
            @NonNull TestData testData,
            @NonNull Set<File> helperApks,
            @NonNull List<? extends DeviceConnector> deviceList,
            int timeoutInMs,
            @NonNull Collection<String> installOptions,
            @NonNull File resultsDir,
            @NonNull File coverageDir,
            @NonNull ILogger logger)
            throws TestException, NoAuthorizedDeviceFoundException, InterruptedException;

    class NoAuthorizedDeviceFoundException extends Exception {

        public NoAuthorizedDeviceFoundException() {
            super("No suitable device connected");
        }
    }
}
