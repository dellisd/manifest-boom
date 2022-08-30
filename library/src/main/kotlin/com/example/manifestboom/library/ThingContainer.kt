package com.example.manifestboom.library

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThingContainer @Inject constructor(){
  private val thingMap: MutableMap<String, Thing> = mutableMapOf()

  fun thing(name: String): Thing = thingMap.getOrPut(name) { Thing(name) }
}
