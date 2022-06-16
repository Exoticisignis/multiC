<template>
  <div class="col mb-3">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title small">Pages: {{ film.name }}</h5>
        <router-link
          :to="{ name: 'Film', params: { id: film.id } }"
          class="card-text text-dark"
        >
          {{ film.name.substr(0, 55) + "..." }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["film"],
};
</script>
