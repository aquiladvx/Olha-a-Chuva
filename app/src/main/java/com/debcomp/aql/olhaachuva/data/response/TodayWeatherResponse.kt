package com.debcomp.aql.olhaachuva.data.response

import com.debcomp.aql.olhaachuva.data.response.CurrentEntry
import com.debcomp.aql.olhaachuva.data.response.Location
import com.debcomp.aql.olhaachuva.data.response.Request
import com.google.gson.annotations.SerializedName


data class TodayWeatherResponse(
    @SerializedName(value = "current")
    val currentEntry: CurrentEntry,
    val location: Location,
    val request: Request
)