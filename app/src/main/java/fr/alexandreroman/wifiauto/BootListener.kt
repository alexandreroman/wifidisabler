/*
 * Copyright 2018 Alexandre Roman
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

package fr.alexandreroman.wifiauto

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import timber.log.Timber

/**
 * [BroadcastReceiver] implementation, listening to the [Intent.ACTION_BOOT_COMPLETED]
 * event.
 * @author Alexandre Roman
 */
class BootListener : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Just in case: make sure the JobScheduler setup is done after
        // the device has completed boot.
        if (intent?.action.equals(Intent.ACTION_BOOT_COMPLETED)) {
            Timber.d("Received event: ACTION_BOOT_COMPLETED")
            context?.let { SetupService.setup(it) }
        }
    }
}
