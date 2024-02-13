Decision: Do not support customisation of the generated code.

This could be considered more of a "product" decision than a technical 
architecture decision - though it heavily affects the technical side. A 
different product decision here could cause very different architecture choices
to be made.

See [plugin-background.md](../plugin-background.md#benefits-of-using-a-project-specific-plugin)
for details - but the underlying concept is there's no single "right" way to 
implement the Builder pattern.

By avoid customisation, the plugin code simple and avoid usage of IDEA
APIs that could increase the maintenance cost.

It also keeps the builder-generator code simple.