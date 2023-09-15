package com.mutia.remote.datasourceimpl.stub

import android.content.Context
import com.mutia.local.util.StubUtil
import com.mutia.remote.R
import com.mutia.remote.datasource.stub.SourceStubDataSource
import com.mutia.remote.dto_res.source.Source
import com.mutia.remote.dto_res.source.SourceRes
import javax.inject.Inject

class SourceStubDataSourceImpl @Inject constructor(
    private val context: Context,
    private val stubUtil: StubUtil
): SourceStubDataSource {

    override suspend fun getSourceByCategory(): SourceRes =
        stubUtil.parseInto(
            jsonString = stubUtil.getJsonFromRaw(context, R.raw.stub_source),
            classOfT = SourceRes::class.java,
            defaultObject = SourceRes(
                "Default Dummy Data", listOf<Source>()
            )
        )!!

}