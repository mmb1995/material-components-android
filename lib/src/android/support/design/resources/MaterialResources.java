/*
 * Copyright (C) 2017 The Android Open Source Project
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

package android.support.design.resources;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleableRes;
import android.support.v7.content.res.AppCompatResources;
import android.text.style.TextAppearanceSpan;

/** Utility methods to resolve resources for components. */
@RestrictTo(LIBRARY_GROUP)
public class MaterialResources {

  private MaterialResources() {}

  /**
   * Returns the {@link ColorStateList} from the given attributes. The resource can include
   * themeable attributes, regardless of API level.
   */
  @Nullable
  public static ColorStateList getColorStateList(
      Context context, TypedArray attributes, @StyleableRes int index) {
    if (attributes.hasValue(index)) {
      int resourceId = attributes.getResourceId(index, 0);
      if (resourceId != 0) {
        ColorStateList value = AppCompatResources.getColorStateList(context, resourceId);
        if (value != null) {
          return value;
        }
      }
    }
    return attributes.getColorStateList(index);
  }

  /**
   * Returns the drawable object from the given attributes.
   *
   * <p>This method supports inflation of {@code <vector>} and {@code <animated-vector>} resources
   * on devices where platform support is not available.
   */
  @Nullable
  public static Drawable getDrawable(
      Context context, TypedArray attributes, @StyleableRes int index) {
    if (attributes.hasValue(index)) {
      int resourceId = attributes.getResourceId(index, 0);
      if (resourceId != 0) {
        Drawable value = AppCompatResources.getDrawable(context, resourceId);
        if (value != null) {
          return value;
        }
      }
    }
    return attributes.getDrawable(index);
  }

  /**
   * Returns a TextAppearanceSpan object from the given attributes.
   *
   * <p>You only need this if you are drawing text manually. Normally, TextView takes care of this.
   */
  @Nullable
  public static TextAppearanceSpan getTextAppearanceSpan(
      Context context, TypedArray attributes, @StyleableRes int index) {
    if (attributes.hasValue(index)) {
      int resourceId = attributes.getResourceId(index, 0);
      if (resourceId != 0) {
        TextAppearanceSpan value = new TextAppearanceSpan(context, resourceId);
        return value;
      }
    }
    return null;
  }
}
