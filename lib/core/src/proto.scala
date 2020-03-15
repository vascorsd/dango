package dango

import dango.generated.GithubApi
import zio._

object test {
  def x = {
    GithubApi.Release
  }
}
