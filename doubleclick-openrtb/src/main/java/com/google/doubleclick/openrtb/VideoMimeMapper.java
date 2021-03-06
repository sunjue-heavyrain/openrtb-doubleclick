/*
 * Copyright 2014 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.doubleclick.openrtb;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.protos.adx.NetworkBid.BidRequest.Video.VideoFormat;

import java.util.Collection;

import javax.annotation.Nullable;

/**
 * Maps between AdX's {@link VideoFormat} and OpenRTB's mime types for video.
 */
public class VideoMimeMapper {
  private static ImmutableMap<String, VideoFormat> openrtbToDc =
      ImmutableMap.<String, VideoFormat>builder()
          .put("video/x-flv", VideoFormat.VIDEO_FLASH)
          .put("video/mp4", VideoFormat.VIDEO_HTML5)
          .put("video/webm", VideoFormat.VIDEO_HTML5)
          .build();
  private static ImmutableSet<String>[] dcToOpenrtb = MapperUtil.multimapEnumToSets(
      ImmutableMultimap.<VideoFormat, String>builder()
          .putAll(VideoFormat.VIDEO_FLASH, "video/x-flv")
          .putAll(VideoFormat.VIDEO_HTML5, "video/mp4", "video/webm")
          .putAll(VideoFormat.YT_HOSTED, "video/x-flv", "video/mp4", "video/webm")
          .build());

  public static ImmutableCollection<String> toOpenRtb(VideoFormat dc) {
    return MapperUtil.get(dcToOpenrtb, dc);
  }

  public static ImmutableSet<String> toOpenRtb(Collection<VideoFormat> dcList) {
    ImmutableSet.Builder<String> openrtbSet = ImmutableSet.builder();

    for (VideoFormat dc : dcList) {
      openrtbSet.addAll(toOpenRtb(dc));
    }

    return openrtbSet.build();
  }

  public static @Nullable VideoFormat toDoubleClick(String openrtb) {
    return openrtbToDc.get(openrtb);
  }

  public static ImmutableSet<VideoFormat> toDoubleClick(Collection<String> openrtbList) {
    ImmutableSet.Builder<VideoFormat> dcSet = ImmutableSet.builder();

    for (String openrtb : openrtbList) {
      VideoFormat dc = toDoubleClick(openrtb);
      if (dc != null) {
        dcSet.add(dc);
      }
    }

    return dcSet.build();
  }
}
