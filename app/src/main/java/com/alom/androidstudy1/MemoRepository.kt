package com.alom.androidstudy1

interface MemoRepository {
    suspend fun getMemo(): String
    suspend fun setMemo(input: String)
}