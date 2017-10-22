import org.redisson.{Redisson, RedissonList}
import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.api.RList
import org.redisson.config.Config
import org.redisson.api.RAtomicLong

object redisson {
//  val redisHost: String = "redis://localhost:32779"
//  val redisPassword: Option[String] = Option.empty


  val helper: Helper = new Helper

  def main(args: Array[String]): Unit = {
    println("args=")
    args.foreach(p => println("   -> " + p))

    val redisHost: String = "redis://" + args(0) + ":" + args(1)

    var redisPassword: Option[String] = Option.empty

    if(args.length >= 3){
      redisPassword = Option.apply(args(2))
    }


    val redisson: RedissonClient = helper.getRedisson(redisHost, redisPassword)

    val test = redisson.getAtomicLong("test")
    test.incrementAndGet
    test.incrementAndGet
    test.incrementAndGet
    val finalRes = test.get()
    test.delete()

    assert(finalRes == 3L, "test was not equal to 3. It is equal to [" + finalRes + "]")

    println("test => [" + finalRes + "], should be 3")

    redisson.shutdown()
  }
}



class Helper {


  def getRedisson(redisHost: String, redisPassword: Option[String]): RedissonClient = {

    println("Rediska info: [" + redisHost + "]")
    val config = new Config()
    val uss = config.useSingleServer
    uss.setAddress(redisHost)

    if(redisPassword.isDefined)
      uss.setPassword(redisPassword.get)

    val redisson = Redisson.create(config)
    redisson
  }


}