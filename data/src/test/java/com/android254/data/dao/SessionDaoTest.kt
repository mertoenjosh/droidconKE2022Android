/*
 * Copyright 2022 DroidconKE
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
package com.android254.data.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.android254.data.db.Database
import com.android254.data.db.model.SessionEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@RunWith(RobolectricTestRunner::class)
class SessionDaoTest {

    private lateinit var sessionDao: SessionDao
    private lateinit var db: Database

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            Database::class.java
        )
            .allowMainThreadQueries() // TODO Please delete me
            .build()
        sessionDao = db.sessionDao()
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        db.close()
    }

    @Test
    fun `test sessionDao fetches all sessions`() = runTest {
        val session = SessionEntity(
            id = 0,
            title = "Retrofiti: A Pragmatic Approach to using Retrofit in Android",
            description = "This session is codelab covering some of the best practices and recommended approaches to building an application using the retrofit library.",
            slug = "retrofiti-a-pragmatic-approach-to-using-retrofit-in-android-1583941090",
            session_format = "Codelab / Workshop",
            session_level = "Intermediate",
<<<<<<< HEAD
            speakers = "",
            rooms = "",
            start_time = "",
            session_image = "",
            start_date_time = "",
            is_serviceSession = false,
            is_keynote = false,
            end_time = "",
            is_bookmarked = true,
            end_date_time = "",
            borderColor = "",
            backgroundColor = ""

=======
            sessionImageUrl = "some-image",
            sessionRoom = "some-room",
            speakerName = "some-guy"
>>>>>>> f76e78fe318e8873cacf788ca95e5788ffa836ca
        )
        sessionDao.insert(session)
        runBlocking {
            val result = sessionDao.fetchSessions().first()
            assertThat(session.title, `is`(result.title))
        }
    }
}