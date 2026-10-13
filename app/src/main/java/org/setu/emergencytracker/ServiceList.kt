package org.setu.emergencytracker



import java.util.concurrent.atomic.AtomicLong

class ServiceList {

    private val services = ArrayList<Service>()
    private val lastId = AtomicLong(0L)

    fun findAll(): List<Service> {
        return services
    }

    fun findOne(id: Long): Service? {
        return services.find { service -> service.id == id }
    }

    fun create(service: Service) {
        service.id = lastId.incrementAndGet()
        services.add(service)
    }

    fun update(service: Service): Boolean {
        val existingService = findOne(service.id)

        return if (existingService != null) {
            existingService.title = service.title
            existingService.desc = service.desc
            existingService.x = service.x
            existingService.y = service.y
            true
        } else {
            false
        }
    }

    fun delete(id: Long): Boolean {
        val existingService = findOne(id)

        return if (existingService != null) {
            services.remove(existingService)
        } else {
            false
        }
    }
}
