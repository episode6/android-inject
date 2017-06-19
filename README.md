# android-inject
Some annotations and modules for bootstrapping android apps with dagger2

### Why
One annoying thing about bootstrapping a new app with dependency injection is starting with an empty graph. This library aims to easy that pain (specifically for android apps using dagger2) by providing a standard set of annotations and modules for android's standard components.

 This library (at least the provided modules) is probably not ideal for a production app, in which one usually wants complete control over how the graph is constructed. It is primarily intended for bootstrapping new apps, to reduce the amount of boiler-plate needed to start writing meaningful code.

### Installation
```groovy
repositories { maven { url "https://oss.sonatype.org/content/repositories/snapshots/" } }
dependencies {
    compile 'com.episode6.hackit.android.inject:context-annotations:0.0.2-SNAPSHOT'
    compile 'com.episode6.hackit.android.inject:context-modules:0.0.2-SNAPSHOT'
    compile 'com.episode6.hackit.android.inject:more-annotations:0.0.2-SNAPSHOT'
}
```

### Whats Included

##### `com.episode6.hackit.android.inject:context-annotations`
 - Qualifier Annotations
   - `@ForApplication`
   - `@ForContextScope`
 - Scope Annotations
   - `@ContextScope`
   - `@ActivityScope`
   - `@ServiceScope`
   - `@ContentProviderScope`
   - `@BroadcastReceiverScope`

##### `com.episode6.hackit.android.inject:context-modules`
The modules in this package provide objects that generally come from a `android.content.Context` object. These include things like `Resources` and `ContentResolver` as well as most standard system services that are fetched via `Context.getSystemService(String)`
 - `ApplicationContextModule` - provides context objects that are qualified with `@ForApplication`
   - Should be included in your application's root module/component.
   - Requires `android.app.Application` be bound in the graph.
 - `ContextModule` - provides unqualified and unscoped context objects
   - Should be included in the component/subcomponent module for your activity/service/contentProvider.
   - Requires `android.content.Context` be bound in the graph.
 - `ScopedContextModule` - identical to ContextModule, but provides objects that are scoped to `@ContextScope`
   - Should be included in the component/subcomponent module for your activity/service/contentProvider.
   - Requires `android.content.Context` be bound in the graph.
   - Requires you component/subcomponent be scoped with `@ContextScope` (note: you can include multiple scopes on a single component and they essentially become aliases)

##### `com.episode6.hackit.android.inject:more-annotations`
 - Qualifier Annotations
   - `@ForUiThread`
   - `@ForWorkerThread`

## License
MIT: https://github.com/episode6/android-inject/blob/master/LICENSE



