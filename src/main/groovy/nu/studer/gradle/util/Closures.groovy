/*
 * Copyright 2014 Etienne Studer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nu.studer.gradle.util

/**
 * Utility class related to Groovy Closures.
 */
final class Closures {

    /**
     * Returns the given value as a string. The string value can also be the result of (recursively) calling a given closure.
     *
     * @param propertyValue the property value to convert
     * @param propertyName the name of the property
     * @return the property value resolved as a string
     */
    static String resolveAsString(def propertyValue, String propertyName) {
        if (propertyValue == null) {
            null
        } else if (propertyValue instanceof String) {
            propertyValue
        } else if (propertyValue instanceof Closure) {
            resolveAsString(propertyValue(), propertyName)
        } else {
            propertyValue.toString()
        }
    }

}
