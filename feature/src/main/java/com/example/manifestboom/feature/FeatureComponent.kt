package com.example.manifestboom.feature

import com.example.manifestboom.library.ThingContainer
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface FeatureComponent {
  fun thingContainer(): ThingContainer
}
