# Architecture Template (MVI Compose)

An example app that should be maintained by relevant updates of architecture.

## Overview

MVI architecture is based on the principles of Clean Architecture. It sets about defining layers and the way that the layers communicate with each other. The GUI component was originally based on MVI and has evolved to use a Redux-like AppState model.

## Functional Layers

This example template contains several root-level functional layers that are used to define what the application itself does:

- **base**
  - contains global, non-app-specific code.
- **app**
  - contains global, app-specific code.
- **dummy**
  - remote data implementation, api-specific interfaces: Retrofit services, Request parameters, Response (JSON transport) objects
- **assay**
  - remote data implementation, parse (in order to use parse please switch to parse branch)
- **product**
  - an example implementation of some features of the current architecture
- **repositories**
  - repositories module
- **services**
  - services module

## Architectural Layers

The architectural layers are transversal subsections of a given functional layer that organize their layer into technical roles:

- **data**
  - business objects, data sources, and repositories go here
- **domain**
  - business logic: Actions, Results, Processors, Reducers
- **presentation**
  - view-specific implementations: Activities, Fragments, ViewModels, ListAdapters, Views, etc...


## MVI Diagram

To have a general view of the architecture please take a look at the links below.

[MVI architecture general description](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=mvi_compose.drawio#R7V1pc5s6F%2F41nsn9kA5i52PiNl1u2zdtun7qUJvYJNjiAm7i%2FvpXYrGNJAS2WW11Oq2RBQbOo7Ofo5EyXjy%2FDmx%2F%2FgFOHW8kS9PnkfJyJMuqJBnoPzyyTkYUFejJyCxwp8kY2A7cuX%2BddFBKR1fu1AlzEyMIvcj184MTuFw6kyg3ZgcBfMpPu4de%2Fld9e%2BZQA3cT26NHv7vTaJ6MmrKxHX%2FjuLN59stAt5JvFnY2OX2ScG5P4dPOkPJqpIwDCKPk0%2BJ57Hj47WXv5fvb9Xfv%2FaP%2B%2Bt2n8D%2F76%2FW%2FXz5%2Bu0wudrPPKZtHCJxldPCl%2Fz7e37z5pj788G9vPj1Jr69%2Bv7tMT5H%2B2N4qfV%2B276ePG62zdxg%2BuQvPXqKj63u4jO7Sb9AbuLY9d7ZEnyfo1pwADfxxgshFr%2F8q%2FSKCPhqdzF1v%2Bt5ewxV%2BgDCyJ4%2FZ0fUcBu5fdFnbQ18BNIC%2BDqIUSbKem3GHz0TDEhoNnBDNuc3eCtgMvbfDKJ0zgZ5n%2B6H7O75hPGVhBzN3eQ2jCC6yC8HVcupM06MNmeODKICPG%2BDg8yvSIqUZfhvO8w4SU9q8duDCiYI1mpJ9q6S0SBcayGD3tEUt0NOxeQ6x6aCdrpTZ5tqbn%2FuMVpa9nKGXsPk9mfw9teLvyXr%2B52wPEX5pR841fo3hLgbRh51H3Q7FyNwDpYBC6RQubHdJARW962gHlJ5zHxVCMvTtibucvY%2FnvFS3I5%2FTZ8VDEJ1778VwmLvTqbOM4RLZkZ0gCmPEh%2B4yil%2BGdo3%2Bolc2ll5oIw3d0Bgdg%2B0x%2BounB9EYLhGy0BPg33EQXJ8cDFkGuLirthxc6zzN9qXtLpRyRN2XgjJFQR%2BtVfSUduTC06Mjh6PMo4WXfmyK2prcMbUVitpXvo90i5XnXDxCvG6lRXz0j6B8rZQ3zI4pD2jST1eLxbqqSiEJlaI%2BlULNS3ikzNPoMFgahXWQRqEQv6eYFX%2BvC41CpRXfqe1jvJ0aR6rIazYr9yilogp5D2E2cyP8s%2F4wfvvw6aX09dcrc%2FV4dXOp0lrFFL1FQcFjFIV2KUiLC3fhe6Eg4TESv10S0pz0JZb4d07wx504gpJVKQkktWtSahQp3zie7wTv4WwmJOMepFQO1HzqI6VOkfKjEz3B4PE8zLDmSKu1qPU8Xz19ldbw3d2P29Xk0bIfZtPrIpetVOASE4ZWC4YWYflU9t3K0ilZWky40r7bK99HyxYRx%2FPOQqhwV3EvXbjMO6b1vBwh3yK9XRCzhx5a9qqUKVo505mTSQf0SuZwBpe292o7SvDa7Zz3EBMw5rAPThStU%2FZvryK4dXvib51nN%2FqRno4%2F%2F8SfESmSo5fPO1%2B9XDO5uLwZGUMPBvGdK%2FjPzc3e5ArhKpg4nHmpOoxfDJeogePZkfsnH3DmcPRbDNAtN78EWp6dW8QlkEidOVF6Vv0cmtb60cK%2BDeDECUMoGHQffe%2FMO6ZVfkTHz850NRFi9jgrvFUyGmwyhisvElQ8xgBvlYomi4rIAorOwSNWExFZpnarRKTjCxMYYDsM3qN%2FPnx7S9FSWNvNW9uGfKC1fVJhTSZg6XDKF4hUxzlWANAVJfQJv8iF%2FYgeEN2eAuJshLE8usLfjXAa5hbgyQgL5gTLKoT0ArGf2HQYMN%2BSK%2BNzT0tdUxtiWwBQBOupcYfefLD%2BkV0AH%2BychQ%2B3p8VH2XmYt7IMwGLTkDYj92NPpcZiltsc22qjYpdzukTrMyqPg4py6lDpEBL6MCGhCkg0Bgmz75BgRhPpkNNtAB9wtYYsXQVIY43Q51VAmzaicKB5dfiSzOS%2FrGz9Hpjo19PSASZ06fATq8Dl9Exw7jruZdCJece0Bf7bDk%2FPhXJo1ng9VG4zGsW844Kk8Qs7DG18n%2Fc4DIEfPDzBVJVuad9m1IJ5x3T0yQ%2FgdDU5PWd3t4RuNbDBvGU6PhU4PgzdCClpzuml%2FHZM7jYjIMxbpuNYYZISLEhdM6nbjJMwb9mqpqUJa7CFMnJAGoPNRkcGZQvSfoyzqSPnrtvh2IOAtudXkeu54cXcCXCpAvpu4iG7wQmFpVAv7StbiWZTtKfNxETM7Jn6LuRNjfJG0Q6VN5vBExY4jJzpCW548WXtn54TqyLjqafQuF2pQzspNvmxJ0nKWiVNPXXJ7Yoa2leRJtIKctdPblZCVbvrm%2FZVJAm3gtr1UxtInbNzOjk3zswV1G6A2krXwSVAe6c4SpiwGZq3GXT5UJvh9E0GmfZRuRhu9zbupSEJ8wEMz2kl044LvvkgmFDzTGjTAZjHhDa5%2F7s4MU6fCdF%2Bi3AV%2Bs5yigbvV7hxiJ8A%2BMKOGdJIuSKYE6422CkxWMbMCU%2FaID%2FRsMe25%2F1GGDs9b21FfibX4Q5h4lSpob6Afcu0O4RnHQtu1kLYT64S99tY2mfGzmhvTsLEghi1F0FSXBuzp127fxzjGJdsxl%2FFNuI%2FO5%2FPlmVpleFZzLKYWJQbY1l7eXgEx2qBY2lU2rqwAjdwpT1UWyswrtY8Yf9kVS5kVIZcbwxB2hVV7HgUTKgFJmSoggkVoTW71WImdLpe86o8aHjOKKXT4vDs817lndILXRnlKjwlUFbjGR%2FdOoGL3hpmkQVRjqrFnNz0jt1qTq7PsiflnIo2QAhoOQSUUL9uQmsVCS3XXrcbn3oVBHEdVDYhZXTbKxMd5UyJkGppq4mbqvMzsVR0gmWRztP8CehDcs%2F1CiR9iLhVNJJ3KX3gXYzmBFxjv2NIg02tcga5VP8vgih9QhmogaLzz2gI1cYQUa0au6i%2BRLCW1D7A2qgKa6MfsNYovy0fo%2FT8MlTrWbpLu6g2h4hqQs%2FsA6AZHUO4pkjXgCa7s6XyoxCe5PxyQJuU47AVQFtDBHSXSrNUEbmgX81uMo%2FMoAitqhYpj%2FEr7J590Rjg7XTYMfMiNUaLL4yJ6Qqfb8mSzJneDNNSh9cJEE3UFBLLfVAt5YrsrB9yGNltBJh1viCmT8g2JykUxJbFPaEhSNOR3HSHUaloB0fRlLeFOkAjjx7mZqMn35SXjVg6mPvu7n8f0cjV2Ww5yl%2FKw4meqHQEN6Xlq%2BfIWYYueiOCnINpPKbRia6ZMGHuJCskSQvVIdKBkuSwiPyQJIlGJ94GzgLiTES8k6ODLxB3bj%2BTbZD5a3o4UkXvtuXyxjT7ufNNvS2X92MWpbaYVtXNn%2B2D2hPfklZsvLD3vRYCp%2F1KICFwtnhlVEonTfxukyadZ7LrI38xD0jQDNG33VIQg71BdNUUL7X2ePJxhB5ill%2BX0Sq1qns3Uy879u%2BSuSpqiXuXnK%2BVOHe1I%2BdnUq1ovm5y5zfjO9ZlsSr2WxVK1VXRj3QashudWhLBI%2Bdn2TVVEyX3nV%2B2KizJ4M1vaFV0ugfUEFdFVaWgJ6vClEnU8lMnyfn9RG31jQOEEd1C%2FC8PGZ1V18QyajcFUKdrROt0%2Bfk5%2B2f1OqrHK9G2PmuK4bY768bh%2B9OQFeprl4a0K8tH%2FBY9p72MW9gIUh6xZVC7pKSD8Kk78gP613MuHiFemjgkho7OtrPQ%2FpRl7hHUKmkNYaHvZ4swDHS2I7MvlYk5tS3Lqi%2B2n3PTsxTFwozErFiNPb8ZQ8Sgu%2FttDBGRRdKVPUJCh2mQWAzWdvpBPYNOevIggthom0Rix53%2B5k5%2BR5VzFaRGHS36mGBrTo6ytN0NU9pruxTBlmpkS2TTKyZbqnG3lEHxpUK1Pmkserbsx6yMsr7kGZjMjseYlJv2r4Kag8mSNmmFIaVm2vZV0HIw2y2bzK2MElrGXVAFKQezobJJBxZSWp51e9oDSNn5ZsnmIJvAdOj30qv2LzL61V3AHGRflC4JXTXVP1v2HXs4VaIrgCHxE%2FPI%2BdnmOIWJc4A7vxkfp0mbZlt3QhZGY9powqnQvFPB0A91KoCTdypkq4vWkb65ztO5qkib9Twcl4IFeIS8WXlnW4eyPzE79yhYg9GC9qRBqTpjyRXVmYxxdazOyERfj5KEanJ6Pr7bjHKSvVI2Z%2FiQhLQEaxiIg8rqtDm1tAdr6EkttFm1RiNLm%2BqYo5AdTMsMJGp%2BiYGk6Npx87VcdnxDPKvTVtZDRHnVmov6UX4cO%2BvUsXcQoTv291RteGv2g52R3EkpaeCcn24aJRltknbkCZpVUqKmcuc3w%2F6ARJvl9DpZTtFPxypVnIDkTvIgz6%2BSdvhUudoOKqJyR8HSGPpVNrYfeBlwUNjSdnONZEGmp3FwYhFFYQbAPd%2B3f4jLJi%2BKuuwBAPp4e3d5%2F%2FePHLx9iH64X35%2B%2F2%2F6JusXOyCu2q34rGx29kRJJLuCl7FVcr5ZovSp5nHz61YSmSCnPV6B48PQjWDgMrIxhau9hQ3jCG8Ia7c4VqLnaZU5MtFKe2GK6nFPz%2FnCXb69zBpm3jGdtfc5Yzjrcy2tqoe0LI97q6SlU4XyskQSxfPdSRWyWIUpVlhs3jx5qcLatztjSbfnLV%2F0yjDroI6eecd0UQpFzDNpKFgPQdssqmfesdgTqdAM5%2BnIu1Y4Dwnt%2B7DZ2g7trAuTLqDCCG1VXcjSlQGrQ%2B2Zmp2A9pLgouuLuJQVK7b3uNZIygB7viaLtC%2FMOjdHAe1SyHcfFrQcjP0JhtdksDWPPRf8pbpC7Wnvx9G5260MhkdnRrib55vrC5k7zdI6LoHzuJ0naHJxmy913RCX6LeTsuHCXCiikKCkvS0AGm9%2BQ1GxTlOnDjU6jZzZife0BCV8xmlhT0tGER3P390VmDdlmmw0ZjHckkwXAKwcWs2aM13Yb04Udu4HSUa5H1cH7nyfVV7Ce%2Bl0IJX1Vta4848G7a9%2Fb9%2B%2B%2Bjm33ecHGWifP%2F16%2FeVXt9k1%2Fcbs89XTV2kN3939uF1NHi37YTa9ZiWHMefJXelwTCrLgsp7UZmRgTwAKg%2FP7pZyNG7QHmNSj6HgM%2Bf1o5%2BmTlSPy4CfJ0fOB4YyalycdOoSOJDRyDlOU6ar14xBhlo%2BAE4zGJdAkTxpmcoMTXcAVB6i9W10SWaGg28AZKbzbmzfH4lmH53nillEsw%2FAyhVjVexapxQKZmKWTi%2B6tkOnchF4ITQX7nQa87FhhAy567n2hh%2FZfoi1c6BOc4sOCiT1zgnBQ0LXbbKIUAPQ%2BI4zcn6J2wxIKm9%2BM3YOI0%2FqCgvNalJSFlKyPil5qRP0Byy5xeyJdVjKFBk6A1V7cHUgJwFdDBCD5F9YvqPVMIUkB5Mp82czZP4yr12WAtCUMO02DHVYWsYLSTLyrkAgqyUylRk0TdjOGHowiB9dkaTxWNcphqQeJZSZ2%2B4werNwl2RPrD%2FQaX%2BuQ%2BECCLgostEvuNSsc9HpG%2FkAt6YT7KRqrf%2BlapgvZDN3MWT5vZANw8r%2BmPlLF9T77x1OBUQpVPYMhbdKnoDuswVNbzDGCQ3ZYngfzvu4rQQ6YH4HhvL5Rf7lJ8h6C9GUzN%2FTf%2Bzt8mZFz%2FNmQy2L63F4cxNwbpo3qzmkWOaBbVguVVN6IavbvivEhWVLemHJ1pZNEyKgLj6tqDrzgQrvmzyB6CS571pBhwGE0e70wPbniaNPefV%2F)

[MVI Workflow](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Untitled%20Diagram.drawio#R5VnbctMwEP2aPJbxJU6dxzYtMEyZ6RAo9IlR7a0tUCyPpNz69Uj2%2BqLYKSmQGspTrNX9nN2zkjLyZ4vNG0Hy9D2PgY08J96M%2FIuR57lj19E%2FxrItLWF4WhoSQWNs1Bjm9AHQiP2SJY1BWg0V50zR3DZGPMsgUpaNCMHXdrN7zuxZc5JAxzCPCOtaP9NYpWh1HaepeAs0SXHqMMCKOxJ9TwRfZjhfxjMoaxakGgabypTEfN0y%2BZcjfyY4V%2BXXYjMDZmCtECv7vd5TWy9ZQKYO6eDBt81t5j8sb%2Bbrr%2B8219dX8vxkjGtT2woKiDUyWORCpTzhGWGXjfW82C6YUR1datpccZ5ro6uN30CpLdJMloprU6oWDGthQ9UX0%2F1VgKVbHMx8X2zahS0WpCJCnRmqtSFiREoaVebXlNVDZ3HVqKCisGC9GabcrtnjXhTRJPlSRPAIdB76KREJqEfa%2BTXXOnyAL0CJre4ngBFFV%2FY6CPpxUrdrCNUfyOkT%2BD0dkl%2B3zW7NdT%2B%2FGn6xbTmFKd6265puRanXL5DytlM4tlM0ntP4hTuMXwRD%2BkVYjrsibIkzfQC5ZOrjNtf65aypFi%2FPyWBtlMzI%2Fc37Xk%2B6Inc6FVjsE0aTzECtkQOhDSsQimqtPcOKBY3j0tFA0gdyV4xneMo5zVSx0%2BB8FFzUtJgBYGMBgokAOzci2yZsf0B0UcfRT5xX3vQU58BcdoLFg4nB0a%2FNbtrD7HTh9%2FdSO8guk%2FWifp1cr0PuyJswjcr5nf5IzEcueARSclHV6Inqyg7TtiKsU6pgnpMiCtb6QGDzv5ezTjDtpSGo6ETsvDGW163kXLVJW3l54hwpXvwOpG9BmEih0sR6aj4ZT7SymJOL2awAs9%2BRWSViLyp8y%2BYxUaQ4q4iyudTgaAfjWQd%2BDaQ6XowZ%2FZallLuFeAr%2BHWac6XXVinqvlXLH9CdodmyaXbeH5kkPzf6xaK4W8Dech6qan%2BRL18qWTfL8Z%2FJlcGC%2BnA6ZLyvxbgnALCVZAnX0n%2BX5XHEBLyNNuk4%2F2q08GYZTO3p%2FL00ePy0GHQoFxMsIRFehB8%2BA4diWRn8ydAZ0h70qPuEq8fdJ3PRAiXO9QTWuGyCXKyiCU5bK5kSoeS9C4sY%2Fl7jxxIrCP3UVmNo9jid50w6je9PUcyvcZEfhgr4z%2FvhZFW7Qx5KnPIY1jyX%2F%2BuHPPfS1ZFhl7N6ob6h5Gxk4htzpzikhHPyUMOkg9SnXN12TPFYFZL33YQ1ckhZ0avxEB9eXegH2Qpu%2FcQ9%2F02e9%2F3bfBWMqc6Iiww6JyueJ6nkwJ1vGSfwf0RVYdHlBT7id9vDlPZ0vXWz%2BGiqPA81fb%2F7lDw%3D%3D)

[Repository And Processor](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Untitled%20Diagram.drawio#R3VrJcqMwEP0aH%2B2yBHg5JrYzc4hnUklVMjnKoIBSgCghb%2Fn6ESAWIewsToztU6JG3aDX%2FVqtljvGJNj8Yijy5tTBfgf2nU3HmHYgBCboiz%2BJZJtJRqNhJnAZceSkUvBA3rAUSj13SRwcKxM5pT4nkSq0aRhimysyxBhdq9NeqK%2B%2BNUIu1gQPNvJ16RNxuCdXAYel%2FDcmrpe%2FGQzG2ZMA5ZPlSmIPOXRdERmzjjFhlPLsv2AzwX4CXo5Lpnez42nxYQyH%2FCMKT%2B58cTufraw%2FcfQ6m0zfHl9XXTCQH8e3%2BYqxIwCQQ8q4R10aIn9WSq8ZXYYOTsz2xaicc0tpJIRACF8x51vpTbTkVIg8HvjyKd4Q%2Fi9R70FLDp8rj6YbaTodbPNByNm2qpWMn6sPS710lCvGHDF%2BlcSCEIQ0xLnshvh%2BoeHkM2wfxTGxM6GcknxZBlSCzk4HSFFMl8zG%2B1CXgYyYi%2FmeeWYRJoJfmAZYLEvoMewjTlbqdyAZ6G4xr4wF8Y8Mh8%2BExigzvEL%2BUr4qQlufIqcxZG7RQlBfcTPyiRsmiAqAMBOCFWacCG5dyQcBcZwsonBM3tAitZe4I6Ik5OmCrOuONS3QTwzgTaeB%2BFK5pFvVL3tCX0dXmu%2F2e%2F3RSJJ5q7zyw%2FhL43fJaipT6MtLLPxed1DxDQf4THcZozaOY8o0p6ksXnuE44cIpXG7FrlcdeVO%2BLXw3wkoHPQVMMdyuC7TKjClzKuk1Fzt2wMcamDpgd2UFiqwqBh%2BPEO8y%2FwdUFawshqgymVfDVDpqZHqKABrHsjym1Sq7jg1O3WPF%2B7NDWUwaIa%2Biw2G5mBkc0LDFEiBY%2BKaC0po8L18BvpDoDjE%2FJZwsRSb3YGq%2F4PJbthu7TKs1i5FufJe7TJUahdwdrWLeVgGO1LtMtaoH2RHk0sgehb4eyuXwWB4XpVLcUo6%2FYOIwsmScVVagtOlpdEmL%2FMdp8LLtGVwj%2BOIhjG%2BDH5WjvdN%2FBQbsTk2FHrCw%2BiZb70AHmvvLeKyJbp%2BqW3w9a7B2bG81c5BXhHWWT4LOeHbC%2BH4%2FsOu2FCMgXlmW7BxQvX0sbbganpQS3NRRYlCa3%2BSSEd3mBGBfRKjn2wDfB%2FfrQP53nyyM2udAAsc9wAPB82JRIj%2Bcg%2FrPa3zTCU7SrKyXADqEfvAaiE%2FJgA1P3VHxyoe9CLwHkc0JpwyfXdou00Jzbb7lEDvYz3hxVVEWscK9Gv5ATZgBY%2BKVUNsURq0jhQcnhxSepF2x%2FALFisSMMBJsoX17B5vHTqzlqfahy6%2F%2FD3%2BzUFbNwJmjegAjHuWauSjlwJW%2FXZBN%2FXTVYV%2BsZk2Bx%2FnuhfPsp54tz14NhcBYlj%2BQCKbXv7MxJj9Bw%3D%3D)

## Communication Mechanism

Due to data synchronization issues inherent in the MVI model, the architecture has evolved by incorporating a Redux-like communication system. In Redux, the entire application's state is modeled (AppState) and is available via the AppController. Actions (ActionType) arrive via the AppController's dispatch method and are passed through processors (ProcessorType). These processors produce asynchronous results (ResultType), which are then reduced to individual substates of the app state via reducers (ReducerType). The AppState is observed via a LiveData property of the AppController. Threading is handled in two parts using Kotlin coroutines: A single background thread is used to process dispatched actions with results being delivered on the main thread. For manually-managed threaded operations such as Bluetooth, individual processors can use the global dispatchers IO and Default via withContext().

## Tests
Product Unit tests are provided to show how to test in module the pure functions. In the product module, all the pure functions from the layers can be covered by unit tests, in case there are challenges of testing some actions. They could be mocked more easily without having to write a full integration test that needs to launch devices.

## MVI Advantages

1. **Declarative UI**: Jetpack Compose allows you to define your UI using a declarative syntax. This means you describe what the UI should look like based on its current state, rather than manually updating and syncing UI elements with data changes. This leads to cleaner and more understandable UI code.

2. **Unidirectional Data Flow**: MVI and Jetpack Compose complement each other well in terms of unidirectional data flow. Data flows in a single direction from the ViewModel to the UI, ensuring predictability and simplifying debugging.

3. **Efficient UI Updates**: Jetpack Compose efficiently updates only the parts of the UI that have changed, reducing the need for manual optimizations and enhancing UI performance.

4. **Type Safety**: Jetpack Compose leverages the power of Kotlin's type system, making it less error-prone compared to XML-based UI frameworks. This type safety extends to data passed between the ViewModel and the UI, reducing the chances of runtime errors.

5. **Reusability**: Jetpack Compose encourages the creation of composable UI components, which are highly reusable. You can easily compose complex UIs from smaller, reusable building blocks, improving code maintainability and reducing duplication.

6. **Easier Testing**: MVI's separation of concerns and Jetpack Compose's composable UI components make it easier to write unit tests for both UI and business logic. You can test your UI components in isolation and the ViewModel separately.

7. **State Management**: MVI simplifies state management, and Jetpack Compose complements it by providing tools for managing UI state changes effectively. You can create and manage UI-related states effortlessly.

8. **Integration with Legacy Code**: If you're working on an existing project with legacy code that doesn't use Jetpack Compose, integrating MVI and Compose can be a solution and an alternative way for communication between different layers.


## MVI Disadvantages

While the combination of the Model-View-Intent (MVI) architectural pattern with Jetpack Compose offers many advantages, it's essential to be aware of potential disadvantages and challenges that developers may encounter:

1. **Learning Curve**: MVI and Jetpack Compose can have steep learning curves, especially for developers who are new to reactive programming or declarative UI development. It may take time to become proficient in these technologies.

2. **Complexity for Simple Apps**: MVI and Jetpack Compose can be overkill for simpler apps with straightforward UI and minimal interactivity. Implementing these technologies in such cases might introduce unnecessary complexity.

3. **Boilerplate Code**: MVI, when implemented in Compose, can lead to more code compared to traditional approaches. Actions, reducers,processors,results and states may introduce boilerplate code, which some developers may find cumbersome.

4. **Initial Setup**: Setting up MVI with Jetpack Compose for a new project can be time-consuming and complex, especially for developers who are not familiar with these technologies.

5. **Debugging Complexity**: While MVI's unidirectional data flow simplifies debugging in some aspects, it can also make debugging more challenging in other scenarios, such as debugging complex data transformations or interactions between Compose components.

6. **Performance Overhead**: Depending on how it's implemented, MVI with Jetpack Compose can introduce performance overhead, especially if not optimized properly.

7. **State Management Complexity**: Managing UI state in Compose can become complex as the app grows. Properly handling UI state and transitions between screens can be challenging, and there may not be one-size-fits-all solutions.

8. **Tooling Support**: While Android Studio provides good support for Jetpack Compose, there may still be occasional issues or limitations in tooling, especially with the integration of more complex architectural patterns like MVI.

## Conclusion

In conclusion, while MVI with Jetpack Compose offers several benefits for Android app development, it's essential to weigh these advantages against the potential disadvantages and consider whether they align with your project's specific requirements and the expertise of your development team. Additionally, the choice of architecture and technology should be influenced by the complexity and goals of your application.

From my point of view, if the project doesn't require a combination of XML-based UI and Compose, better to use the standard recommendation architecture by Google.

## Parse (alternative remote server)

To have a clear view of repositories implemented as an alternative remote source, please set up parse(https://parseplatform.org/) server locally or find something remote and change the params "PARSE_URL", "PARSE_APPLICATION_ID" from build.gradle

## About used libraries
- [Dependency injection(Koin)](https://insert-koin.io)
- [Networking Library(Retrofit2)](https://square.github.io/retrofit/)
- [Logger(Timber)](https://github.com/JakeWharton/timber)
- [Parse](https://parseplatform.org/)

## List of clean architectures
- [MVI XML-based UI](https://github.com/colodinalexandru/MVIViewCustom)
- [MVVM XML-based UI](https://github.com/colodinalexandru/mvvmview)
- [MVI Compose](https://github.com/colodinalexandru/MVICompose)
- [Compose Standard](https://github.com/colodinalexandru/standardcompose)

# Feel free to ask any questions 
## [colodind.alexandru@gmail.com](mailto:colodind.alexandru@gmail.com)


