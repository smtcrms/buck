/*
 * Copyright 2018-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.skylark.function;

import com.google.devtools.build.lib.cmdline.Label;
import com.google.devtools.build.lib.events.Location;
import com.google.devtools.build.lib.skylarkinterface.Param;
import com.google.devtools.build.lib.skylarkinterface.SkylarkCallable;
import com.google.devtools.build.lib.skylarkinterface.SkylarkConstructor;
import com.google.devtools.build.lib.skylarkinterface.SkylarkGlobalLibrary;
import com.google.devtools.build.lib.skylarkinterface.StarlarkContext;
import com.google.devtools.build.lib.syntax.Environment;
import com.google.devtools.build.lib.syntax.EvalException;

/**
 * Interface for a global Skylark library containing rule-related helper and registration functions.
 */
@SkylarkGlobalLibrary
public interface SkylarkRuleFunctionsApi {
  @SkylarkCallable(
      name = "Label",
      doc =
          "Creates a Label referring to a BUILD target. Use "
              + "this function only when you want to give a default value for the label "
              + "attributes. The argument must refer to an absolute label. "
              + "Example: <br><pre class=language-python>Label(\"//tools:default\")</pre>",
      parameters = {
        @Param(name = "label_string", type = String.class, doc = "the label string."),
      },
      useLocation = true,
      useEnvironment = true,
      useContext = true)
  @SkylarkConstructor(objectType = Label.class)
  Label label(String labelString, Location loc, Environment env, StarlarkContext context)
      throws EvalException;
}
