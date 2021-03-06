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

import com.google.openrtb.OpenRtb;
import com.google.openrtb.OpenRtb.BidRequest.Geo.Builder;
import com.google.protos.adx.NetworkBid;
import com.google.protos.adx.NetworkBid.BidRequest;
import com.google.protos.adx.NetworkBid.BidRequest.HyperlocalSet;

/**
 * Extension mapper for {@link DoubleClickOpenRtbMapper}. The core mapper only handles the
 * properties that can be mapped to standard OpenRTB fields; you must provide one or
 * more extension mappers to perform other mappings (usually from/to OpenRTB extensions).
 */
public abstract class ExtMapper {
  protected ExtMapper() {
  }

  public void toOpenRtbBidRequest(
      NetworkBid.BidRequest dcRequest, OpenRtb.BidRequest.Builder request) {
  }

  public void toOpenRtbDevice(NetworkBid.BidRequest dcRequest,
      OpenRtb.BidRequest.Device.Builder device) {
  }

  public void toOpenRtbImpression(NetworkBid.BidRequest.AdSlot dcSlot,
      OpenRtb.BidRequest.Impression.Builder imp) {
  }

  public void toOpenRtbBanner(NetworkBid.BidRequest.AdSlot dcSlot,
      OpenRtb.BidRequest.Impression.Banner.Builder banner) {
  }

  public void toOpenRtbVideo(NetworkBid.BidRequest.Video dcVideo,
      OpenRtb.BidRequest.Impression.Video.Builder video) {
  }

  public void toOpenRtbPMP(NetworkBid.BidRequest.AdSlot.MatchingAdData dcAdData,
      OpenRtb.BidRequest.Impression.PMP.Builder pmp) {
  }

  public void toNativeAd(OpenRtb.BidRequest request, OpenRtb.BidResponse response,
      OpenRtb.BidResponse.SeatBid.Bid bid, NetworkBid.BidResponse.Ad.Builder dcAd) {
  }

  public void toOpenRtbGeo(BidRequest dcRequest, Builder geo, HyperlocalSet hyperlocalSet) {
  }
}
