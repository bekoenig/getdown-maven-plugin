/*
 * Copyright 2018-2019 rockfireredmoon
 * Copyright 2026 bekoenig
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.bekoenig.getdown.maven;

/**
 * Keystore configuration
 *
 * @author tchemit <chemit@codelutin.com>
 * @since 1.0-beta-3
 */
public class KeystoreConfig {
    private boolean delete;

    private boolean gen;

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isGen() {
        return gen;
    }

    public void setGen(boolean gen) {
        this.gen = gen;
    }
}
