package indie.jithinjude.dev

import android.app.Application
import timber.log.Timber

/**
 * Created by JithinJude on 13,June,2023
 */
class PersonalLibrariesApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}