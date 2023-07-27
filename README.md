# Spring Learning

### [22 jul 2023] 
	- Created Spring Repository

### [23 jul 2023]
	- Property Injection By: 
		Value Tag, Value Attribute and P schema
	- Property Injection By:
		list, set, map

### [24 jul 2023]
	- Property Injection By Reference Type
	- Constructor Injection
	- Added List in Constructor Injection

### [25 jul 2023]
	* Implementing Bean lifecycle methods
	
	- Using XML (init-method, destroy-method), AbstractApplicationContext interface(registerShutDownHook).
	- implementing interfaces i) initializingBean ii)isposableBean
	- Using Annotations @PostConstruct and @PreDestroy

### [26 jul 2023]
	* Autowiring in spring
	- Feature of spring framework in which spring container inject the dependencies automatically.

	Advantages: 
	- Automatic
	- less code
	
	Disadvantage: 
	- No control of programmer
	- no use for primitive and String values

	* Autowiring in XML by using:
	- byName, byType, constructor.

	*Autowiring using Annotation on:
	- setter methos, property, constructore.

### [27 jul 2023]
	* Qualifire Annotation
	- @Qualifier annotation to mark a bean as ready for AutoWiring.
	- @Qualifier is used along with @Autowired annotation to specify the exact bean for auto wiring by Spring container

	* Spring Standalone Collections
	- creating standalone collection [list, set, map] using util schema. 	

	* StereoType Annotions:
	- @Component

