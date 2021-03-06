package com.hanan.githubuser3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class GitUser (
    var username: String? = null,
    var name: String? = null,
    var company: String? = null,
    var location: String? = null,
    var repository: String? = null,
    var followers: String? = null,
    var following: String? = null,
    var image: Int? = null
) :Parcelable