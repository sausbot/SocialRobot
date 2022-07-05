package furhatos.app.socialrobot

import furhatos.app.socialrobot.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class SocialrobotSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
