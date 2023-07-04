package umbjm.ft.inf.retrofit.data

import com.google.gson.annotations.SerializedName

data class ApiPublic(

	@field:SerializedName("entries")
	val entries: EntriesItem? = null,

	@field:SerializedName("count")
	val count: Int? = null
)
