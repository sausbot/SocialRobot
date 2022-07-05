package furhatos.app.socialrobot.flow

import furhatos.app.socialrobot.flow.main.Idle
import furhatos.app.socialrobot.setting.distanceToEngage
import furhatos.app.socialrobot.setting.maxNumberOfUsers
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.Voice

val Init : State = state() {
    init {
        /** Set our default interaction parameters */
        users.setSimpleEngagementPolicy(distanceToEngage, maxNumberOfUsers)
        furhat.voice = Voice("Matthew")
        /** start the interaction */
        goto(Idle)
    }
}
