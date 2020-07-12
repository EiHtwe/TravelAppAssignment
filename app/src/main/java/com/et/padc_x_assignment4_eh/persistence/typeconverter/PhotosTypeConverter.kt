package com.et.padc_x_assignment4_eh.persistence.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhotosTypeConverter {
    @TypeConverter
    fun toString(UserList: ArrayList<String>) : String {
        return Gson().toJson(UserList)
    }

    @TypeConverter
    fun toUserList(userListJsonString: String): ArrayList<String>{
        val userListType = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(userListJsonString, userListType)
    }
}
