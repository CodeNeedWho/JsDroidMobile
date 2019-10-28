/*
 * Copyright (C) 2012 The Android Open Source Project
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

package com.jsdroid.uiautomator2;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * This class contains static helper methods to work with
 * {@link AccessibilityNodeInfo}
 */
public class AccessibilityNodeInfoHelper {

    /**
     * Returns the node's bounds clipped to the size of the display
     *
     * @param node
     * @param screenWidth pixel width of the display
     * @param screenHeight pixel height of the display
     * @return null if node is null, else a Rect containing visible bounds
     */
    public static Rect getVisibleBoundsInScreen(AccessibilityNodeInfo node, int screenWidth, int screenHeight) {
        if (node == null) {
            return null;
        }
        // targeted node's bounds
        Rect nodeRect = new Rect();
        node.getBoundsInScreen(nodeRect);

        Rect displayRect = new Rect();
        displayRect.top = 0;
        displayRect.left = 0;
        displayRect.right = screenWidth;
        displayRect.bottom = screenHeight;

        nodeRect.intersect(displayRect);
        return nodeRect;
    }
}
