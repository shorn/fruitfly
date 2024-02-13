
Fruitfly is not intended be published in the plugin marketplace.

If you want to customise how it works, especially the code it generates - 
the intent is for you to fork it, or copy it into your target project, and then
customise it to the requirements of your specific project.

Fruitfly is [MIT licenced](./licence.md) - so I couldn't prevent you from 
publishing it to the marketplace even if I wanted to. 
But please re-label it if you do that. 
That is: fork the repo, rename it and set your own vendor and support email in
plugin.xml.

To customise the generated code:

* fork the project
* edit [BuilderGenerator.java](src/main/java/fruitfly/psi/BuilderGenerator.java)
  and customise the generated code

See [plugin-structure.md](./doc/plugin-structure.md) for quick summary of the project structure.


# Developing the plugin

See [plugin-development.md](./doc/plugin-development.md).