package flavours

import build.BuildDimensions
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.LibraryProductFlavor
import org.gradle.api.NamedDomainObjectContainer

sealed class BuildFlavor(val name: String) {

    // It's used for app
    abstract fun create(
        namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
    ): ApplicationProductFlavor

    // It's used for modules
    abstract fun createLibrary(
        namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
    ): LibraryProductFlavor

    object Google : BuildFlavor(FlavourTypes.GOOGLE) {
        override fun create(
            namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
        ): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE
                applicationIdSuffix = ".$name"
                versionNameSuffix = "-$name"
            }
        }

        override fun createLibrary(
            namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
        ): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE
            }
        }
    }

    object Huawei : BuildFlavor(FlavourTypes.HUAWEI) {
        override fun create(
            namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
        ): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE
            }
        }

        override fun createLibrary(
            namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
        ): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE
            }
        }
    }

    object Customer : BuildFlavor(FlavourTypes.CUSTOMER) {
        override fun create(
            namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
        ): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP
                applicationIdSuffix = ".$name"
                versionNameSuffix = "-$name"
            }
        }

        override fun createLibrary(
            namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
        ): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP
            }
        }
    }

    object Driver : BuildFlavor(FlavourTypes.DRIVER) {
        override fun create(
            namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>
        ): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP
                applicationIdSuffix = ".$name"
                versionNameSuffix = "-$name"
            }
        }

        override fun createLibrary(
            namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>
        ): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP
            }
        }
    }

}