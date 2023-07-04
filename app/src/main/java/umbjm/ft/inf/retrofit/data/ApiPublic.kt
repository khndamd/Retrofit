package umbjm.ft.inf.retrofit.data

import com.google.gson.annotations.SerializedName

data class ApiPublic(

	@field:SerializedName("entries")
	val entries: Entries? = null,

	@field:SerializedName("count")
	val count: Int? = null
)
